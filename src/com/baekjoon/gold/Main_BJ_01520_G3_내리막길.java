package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01520_G3_내리막길 {
	static int M, N, cnt;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	static int[][] arr, dp;
	
	static class Node{
		int y, x, val;

		public Node(int y, int x, int val) {
			super();
			this.y = y;
			this.x = x;
			this.val = val;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [y=");
			builder.append(y);
			builder.append(", x=");
			builder.append(x);
			builder.append(", val=");
			builder.append(val);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	static int dfs(int y, int x) {
		if(y == N-1 && x == M-1) {
			return 1;
		}
		
		if(dp[y][x] != -1) {
			return dp[y][x];
		}
		
		dp[y][x] = 0;
	
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0<=ny && 0<=nx && ny<N && nx<M) {
				if(arr[y][x] > arr[ny][nx]) {
					dp[y][x] += dfs(ny, nx);
				}
			}
		}
		
		return dp[y][x];
	}
}
