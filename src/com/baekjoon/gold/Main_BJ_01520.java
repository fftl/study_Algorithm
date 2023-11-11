package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://hidelookit.tistory.com/171
public class Main_BJ_01520_G3_내리막길 {
	static int M, N, cnt;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		board = new int[M][N];
		boolean[][] visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[0][0] = true;
		dfs(board[0][0], 0, 0, visited);
		System.out.println(cnt);
	}
	
	static void dfs(int now, int y, int x, boolean[][] visited) {
		if(y==M-1 && x==N-1) {
			cnt++;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(0<=ny && ny<M && 0<=nx && nx<N && !visited[ny][nx] && board[ny][nx]<now) {
				visited[ny][nx] = true;
				dfs(board[ny][nx], ny, nx, visited);
				visited[ny][nx] = false;			
				}
		}
	}
}
