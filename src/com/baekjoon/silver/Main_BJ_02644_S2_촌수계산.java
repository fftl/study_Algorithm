package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_02644_S2_촌수계산 {
	static int N, a, b;
	static int result;
	
	static HashMap<Integer, ArrayList<Integer>> map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			map.put(i, new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map.get(q).add(w);
			map.get(w).add(q);
		}
		
		result = -1;
		boolean[] visited = new boolean[N+1];
		visited[a] = true;
		
		dfs(a, 0, visited);
		
		System.out.println(result);
	}
	
	static void dfs(int num, int cnt, boolean[] visited) {
		if(num == b) {
			result = cnt;
			return;
		}
		
		for(int n : map.get(num)) {
			if(!visited[n]) {
				visited[n] = true;
				dfs(n, cnt+1, visited);
			} 
		}
	}
}
