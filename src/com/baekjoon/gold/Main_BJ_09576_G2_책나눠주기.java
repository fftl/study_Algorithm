package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_09576_G2_책나눠주기 {
	static boolean[] check;
	static int[] p;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			check = new boolean[N+1];
			p = new int[N+1];
			//완탐 불가능
			//학생들을 정렬해서 우선순위를 정해야할듯
			//=>이분매칭 이라는 알고리즘이 존재
			list = new ArrayList<>();
			list.add(new ArrayList<>());
			
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				ArrayList<Integer> now = new ArrayList<>();
				for (int k = a; k <= b; k++) {
					now.add(k);
				}
				
				list.add(now);
			}
			
			int res = 0;
			
			for (int j = 1; j<=M; j++) {
				Arrays.fill(check, false);
				if(dfs(j)) res++;
			}
			
			System.out.println(res);
		}
		
	}
	
	static boolean dfs(int idx) {
		for(int num : list.get(idx)) {
			if(!check[num]) {
				check[num] = true;
				if(p[num] == 0 || dfs(p[num])) {
					p[num] = idx;
					return true;
				}
			}
		}
		
		return false;
	}
}
