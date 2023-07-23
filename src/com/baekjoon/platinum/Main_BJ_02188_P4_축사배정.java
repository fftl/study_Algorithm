package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_02188_P4_축사배정 {
	static boolean[] check;
	static int[] p;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		check = new boolean[M+1];
		p = new int[M+1];
		
		list = new ArrayList<>();
		list.add(new ArrayList<>());
		
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> now = new ArrayList<>();
			
			int n = Integer.parseInt(st.nextToken());
			for (int k = 0; k < n; k++) {
				now.add(Integer.parseInt(st.nextToken()));
			}
			
			list.add(now);
		}
		
		int res = 0;
		
		for (int j = 1; j<=N; j++) {
			Arrays.fill(check, false);
			if(dfs(j)) res++;
		}
		
		System.out.println(res);
		
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
