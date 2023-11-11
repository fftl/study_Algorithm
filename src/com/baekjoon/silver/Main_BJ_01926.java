package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01926_S1_그림 {
	static int n, m, cnt, max, now;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		visited = new boolean[n][m];
		
		cnt = 0;
		max = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j] && board[i][j] == 1) {
					now = 0;
					visited[i][j] = true;
					dfs(i, j);
					max = Math.max(max, now);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
	
	static void dfs(int y, int x) {
		now++;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0<=ny && ny<n && 0<=nx && nx<m && board[ny][nx] == 1 && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx);
			}
		}
	}
}
