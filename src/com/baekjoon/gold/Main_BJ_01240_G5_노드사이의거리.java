package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_01240_G5_노드사이의거리 {
	static int N, M;
	static StringBuilder sb;
	static int[][] dis;
	static ArrayList<ArrayList<Integer>> arr;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList<>();
		for(int i=0; i<=N; i++) arr.add(new ArrayList<>());

		dis = new int[N+1][N+1];

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			arr.get(s).add(e);
			arr.get(e).add(s);

			dis[s][e] = k;
			dis[e][s] = k;
		}

		sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[N+1];
			visited[s] = true;

			find(visited, s, e, 0);
		}

		System.out.println(sb.toString().trim());
	}

	static void find(boolean[] visited, int now, int end, int k){
		if(now==end){
			sb.append(k+"\n");
			return;
		} else {
			for(int e : arr.get(now)){
				if(visited[e]) continue;
				visited[e] = true;
				find(visited, e, end, k+dis[now][e]);
			}
		}
	}
}
