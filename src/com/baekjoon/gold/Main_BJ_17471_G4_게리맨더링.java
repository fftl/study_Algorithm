package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17471_G4_게리맨더링 {
	
	static List<List<Integer>> con = new ArrayList<>();
	static int[] comb, size;
	static int N, min;
	
	//나누어진 두 지역이 각각 연결되어 있는지 확인
	static boolean check() {
		boolean[] ateam = new boolean[11];
		boolean[] bteam = new boolean[11];
		
		for (int i = 1; i < 11; i++) {
			boolean k = false;
			for (int j = 0; j < comb.length; j++) {
				if(i==comb[j]) {
					k = true;
					break;
				}
			}
			
			if(k) ateam[i] = true;
			else bteam[i] = true;
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] avisited = new boolean[11];
		boolean[] bvisited = new boolean[11];
		for (int i = 0; i < avisited.length; i++) {
			if(bteam[i]) avisited[i] = true;
		}
		for (int i = 0; i < avisited.length; i++) {
			if(ateam[i]) bvisited[i] = true;
		}
		
		avisited[comb[0]] = true;
		ateam[comb[0]] = false;
		q.add(comb[0]);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int k = q.poll();
				List<Integer> now = con.get(k);
				
				for (int j = 0; j < now.size(); j++) {
					int nowI = now.get(j);
					if(!avisited[nowI]) {
						ateam[nowI] = false;
						avisited[nowI] = true;
						q.add(nowI);
					}
				}
			}
		}
		
		q = new LinkedList<>();
		int sIdx = 0;
		for (int i = 1; i < 11; i++) {
			if(bteam[i]) {
				sIdx = i;
				break;
			}
		}
		
		bvisited[sIdx] = true;
		bteam[sIdx] = false;
		q.add(sIdx);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int k = q.poll();
				List<Integer> now = con.get(k);
				
				for (int j = 0; j < now.size(); j++) {
					int nowI = now.get(j);
					if(!bvisited[nowI]) {
						bteam[nowI] = false;
						bvisited[nowI] = true;
						q.add(nowI);
					}
				}
			}
		}
		
		
		boolean ateamS = true;
		boolean bteamS = true;
		for (int i = 0; i <= N; i++) {
			if(ateam[i]) ateamS = false;
			if(bteam[i]) bteamS = false;
		}
		
		return ateamS == true && bteamS == true;
	}
	
	static void checkPerson() {
		int a = 0;
		int b = 0;
		
		for (int i = 1; i <= N; i++) {
			boolean c = false;
			for (int j = 0; j < comb.length; j++) {
				if(i==comb[j]) {
					c = true;
					break;
				}
			}
			
			if(c) a+=size[i];
			else b+=size[i];
		}
		
		int result = Math.abs(a-b);
		
		min = Math.min(min, result);
	}
	
	//선택가능한 지역구 뽑기
	static void combination(int s, int cnt, int max) {
		if(cnt == max) {
			if(check()) {
				checkPerson();
			}
			return;
		}
		
		for (int i = s; i <= N; i++) {
			comb[cnt] = i;
			combination(i+1, cnt+1, max);
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		
		size = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N; i++) {
			con.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++) {
				int k = Integer.parseInt(st.nextToken());
				con.get(i).add(k);
			}
		}
		
		for (int i = 1; i <= N-1; i++) {
			comb = new int[i];
			combination(1, 0, i);
		}
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
}
