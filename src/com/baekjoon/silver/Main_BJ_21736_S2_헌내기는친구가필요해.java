package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_21736_S2_헌내기는친구가필요해 {
	static int N, M;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int sy = -1;
		int sx = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 'I') {
					sy = i; 
					sx = j;
					break;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sy, sx});
		visited[sy][sx] = true;
		
		int res = 0;
		while(!q.isEmpty()) {
	
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int[] now = q.poll();
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
					
					if(0<=ny && ny<N && 0<=nx && nx<M && !visited[ny][nx]) {
						if(board[ny][nx] == 'P' || board[ny][nx] == 'O') {
							if(board[ny][nx] == 'P') res++;
							visited[ny][nx] = true;
							q.add(new int[] {ny,nx});
						}
					}
				}
			}
		}
		
		if(res == 0) System.out.println("TT");
		else System.out.println(res);
	}
}
