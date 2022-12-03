package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_JO_01681_해밀턴순환회로 {

	static int N, result;
	static int[][] map;
	static boolean[] visited;
	
	static void dfs(int point, int cnt, int weight) {
		if(weight>result) return;
		
		if(cnt == N) {
			result = Math.min(result, weight+map[point][1]);
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(i, cnt+1, map[point][i]+weight);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		
		result = Integer.MAX_VALUE;
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N+1];
		visited[1] = true;
		dfs(1, 1, 0);
		
		System.out.println(result);
	}
}
