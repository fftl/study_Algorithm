package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02468_S1_안전영역 {
	static int N, max, result, cnt;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] board;
	static boolean[][] visited;
	
	static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(0<= ny && ny<N && 0<=nx && nx<N) {
				if(board[ny][nx] != -1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		result = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int high = Integer.parseInt(st.nextToken());
				max = Math.max(high, max);
				board[i][j] = high;
			}			
		}
		
		int now = 1;
		while(now<max) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(board[i][j] <= now) {
						board[i][j] = -1;
					}
				}
			}
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && board[i][j] != -1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			result = Math.max(cnt, result);
			now++;
		}

		System.out.println(result);
	}

}
