package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main_BJ_20541_P5_앨범정리 {
	
	static TreeMap<String, Album> map;
	static String pointer;
	static Queue<String> deleteList;
	
	static class Album{
		String name; //앨범의 이름
		String pName; //부모 앨범 이름
		int pickCnt; //해당 앨범 자체의
		int subPickCnt; //하위 사진 수
		int subAlbumCnt; //하위 앨범 수
		
		TreeSet<String> subAlbumName = new TreeSet<>(); //하위 앨범들의 이름
		TreeSet<String> pickName = new TreeSet<>(); //앨범의 사진 이름
		
		public Album(String name, String pName, int pickCnt) {
			this.name = name;
			this.pName = pName;
			this.pickCnt = pickCnt;
			this.subPickCnt = pickCnt;
			this.subAlbumCnt = 0;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		//최상위의 album을 먼저 생성해줍니다!!
		map = new TreeMap<>();
		map.put("album", new Album("album", "null", 0));
		pointer = "albue"; //포인터의 시작인 album을 설정해줍니다.
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			String value = st.nextToken();
			
			if(key.equals("mkalb")) {
				Album nowAlbum = map.get(pointer);
				
				//이미 value의 이름을 가진 앨범이 존재한다면 수행 불가!
				if(nowAlbum.subAlbumName.contains(value)) {
					sb.append("duplicated album name\n");
				} else {
					//포인터 앨범의 하위앨범 목록에 추가해주고
					//map에 앨범을 생성합니다.
					//그리고 포인터 앨범이 하위앨범 하나를 더 가졌음을 표시해줍니다.
					nowAlbum.subAlbumName.add(value);
					map.put(value, new Album(value, pointer, 0));
					nowAlbum.subAlbumCnt++;
				}
				
			} else if(key.equals("rmalb")) {
				Album nowAlbum = map.get(pointer);
				if(nowAlbum.subAlbumCnt == 0) continue;
				
				deleteList = new LinkedList<>();
				
				//이름 순 첫번째 앨범을 삭제합니다.
				if(value.equals("-1")) {
					String firstAlbum = nowAlbum.subAlbumName.first();
					//이름 순 첫번째 앨범의 부모는 바로 pointer! pointer부터 재귀를 이용해 부모를 계속 찾아가며 제거된 앨범과 사진 수를 계산해줍니다.
					removeParentUpdate(pointer, nowAlbum.subAlbumCnt, nowAlbum.subPickCnt);
					removeAlbum(firstAlbum);
					
					//모두 삭제해줍니다.
					while(!deleteList.isEmpty()) {
						map.remove(deleteList.poll());
					}
					
					//이제 자식들을 Album들을 실제로 제거해줍니다.
				} else if(value.equals("0")) {
					
				} else if(value.equals("1")) {
					String lastAlbum = nowAlbum.subAlbumName.last();
				} else {
					
				}
				
			} else if(key.equals("insert")) {
				
			} else if(key.equals("delete")) {
				
			} else if(key.equals("ca")) {
				
			}
		}
	}
	
	//앨범이 삭제 됨으로 변경 될 부모의 총 앨범, 사진수를 갱신해줍니다.
	static void removeParentUpdate(String pName, int albumCnt, int pickCnt) {
		
		//부모가 null이면 루트까지 온 것!
		if(pName.equals("null")) return;
		
		//제거된 앨범수, 사진수를 계산해줍니다.
		Album nowAlbum = map.get(pName);
		nowAlbum.subAlbumCnt -= albumCnt;
		nowAlbum.subPickCnt -= pickCnt;
		
		removeParentUpdate(nowAlbum.pName, albumCnt, pickCnt);
		
	}
	
	//rmalb -1, 1, S일 때
	//재귀를 통해서 해당 앨범의 하위 앨범들을 모두 구해줍니다.
	static void removeAlbum(String name) {
		Album nowAlbum = map.get(name);
		for (String dName : nowAlbum.subAlbumName) {
			deleteList.add(dName);
			removeAlbum(dName);
		}
	}
	
	//rmalb 0일 때
	static void removeAlbum(TreeSet<String> names) {
		
	}
}
