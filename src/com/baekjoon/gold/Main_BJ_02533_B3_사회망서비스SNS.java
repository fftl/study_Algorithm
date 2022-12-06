package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//https://maivve.tistory.com/322
public class Main_BJ_02533_B3_사회망서비스SNS {
	static int n;
	static boolean[] visited;
	static List<Integer>[] graph;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		dp = new int[n+1][2];
		visited = new boolean[n+1];
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}
		
		dfs(1);
		System.out.println(Arrays.deepToString(dp));
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	static void dfs(int number) {
		visited[number] = true;
		dp[number][0] = 0;
		dp[number][1] = 1;
		
		for(int child : graph[number]) {
			if(!visited[child]) {
				dfs(child);
				dp[number][0] += dp[child][1];
				dp[number][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}
}
