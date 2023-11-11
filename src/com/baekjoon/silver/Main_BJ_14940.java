package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14940_S1_쉬운최단거리 {
	
	static int N, M;
	static int[][] board, cnt;
	static boolean[][] visited;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		cnt = new int[N][M];
		visited = new boolean[N][M];
		
		
		int sy = -1;
		int sx = -1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) {
					sy = i;
					sx = j;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sy, sx});
		visited[sy][sx] = true;
		
		int n = 1;
		while(!q.isEmpty()) {
			int len = q.size();
			
			for (int i = 0; i < len; i++) {
				int[] now = q.poll();
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
					
					if(0<=ny && ny<N && 0<=nx && nx<M && !visited[ny][nx] && board[ny][nx] != 0) {
						visited[ny][nx] = true;
						cnt[ny][nx] = n;
						q.add(new int[] {ny, nx});
					}
				}
			}
			n++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cnt[i][j] == 0 && board[i][j] == 1) sb.append(-1+" ");
				else sb.append(cnt[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
