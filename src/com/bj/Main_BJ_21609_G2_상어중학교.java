package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_21609_G2_상어중학교 {
	
	static class Group{
		int sy, sx, rCnt;
		ArrayList<int[]> points;
		
		public Group(int sy, int sx, int rCnt, ArrayList<int[]> points) {
			this.points = points;
			this.sy = sy;
			this.sx = sx;
			this.rCnt = rCnt;
		}
	}

	static int N, M, maxCnt, maxNum;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<ArrayList<int[]>> groups;
	static ArrayList<Group> standards;
	
	//기준블록 찾기
	static void findStandard() {
		int rCnt = 0;
		for (int i = 0; i < groups.size(); i++) {
			int y = 20;
			int x = 20;
			
			ArrayList<int[]> now = groups.get(i);
			
			for (int[] n : now) {
				if(map[n[0]][n[1]] == 0) {
					rCnt++;
					continue;
				}
				
				if(y>n[0]) {
					y = n[0];
					x = n[1];
				} else if(y==n[0]) {
					if(x>n[1]) {
						y = n[0];
						x = n[1];
					}
				}
			}
			standards.add(new Group(y, x, rCnt, now));
		}
		
		Collections.sort(standards, new Comparator<>());
	}
	
	//가장 큰 블록 그룹 구하기
	static void findGroup() {
		visited = new boolean[N][N];
		groups = new ArrayList<>();
		standards = new ArrayList<>();
		
		maxCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				
				int num = map[i][j];
				if(num == -1 || num==0) continue;
				int nowCnt = 0;
				ArrayList<int[]> nowGroup = new ArrayList<>();
				
				Queue<int[]> q = new LinkedList<>();
				nowGroup.add(new int[] {i,j});
				q.add(new int[] {i,j});
				visited[i][j] = true;
				
				while(!q.isEmpty()) {
					int size = q.size();
					for (int k = 0; k < size; k++) {
						nowCnt++;
						int[] now = q.poll();
						int nowy = now[0];
						int nowx = now[1];
						
						for(int l=0; l<4; l++) {
							int ny = nowy + dy[l];
							int nx = nowx + dx[l];
							
							if(0<=ny && ny<N && 0<=nx && nx<N && visited[ny][nx] == false) {
								if(map[ny][nx] == num || map[ny][nx] == 0) {
									q.add(new int[] {ny, nx});
									nowGroup.add(new int[] {ny, nx});
									visited[ny][nx] = true;
								}
							}
						}
						
					}
				}
				
				if(maxCnt<nowCnt) {
					maxCnt = nowCnt;
					maxNum = num;
					groups.clear();
					groups.add(nowGroup);
				}
			}
		}
		
		if(groups.size()>1) {
			cntRainbow();
			for (int i = 0; i < rainbows; i++) {
				
			}
			findStandard();
		}
		
		System.out.println("최고그룹개수>>"+groups.size());
		System.out.println("최고개수>>"+maxCnt);
		System.out.println("최고숫자>>"+maxNum);
//		for (int i = 0; i < group.size(); i++) {
//			System.out.println(group.get(i)[0]+","+group.get(i)[1]);
//		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		findGroup();
	}
}
