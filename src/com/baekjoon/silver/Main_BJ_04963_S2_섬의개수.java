package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_04963_S2_섬의개수 {
	static int Y, X;
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[][] board;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		while(true){
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			if(X==0 && Y==0) break;
			board = new int[Y][X];

			for (int i = 0; i < Y; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < X; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if(board[i][j] == 1){
						Queue<int[]> q = new LinkedList<>();
						q.add(new int[]{i, j});
						cnt++;

						while(!q.isEmpty()){
							int[] now = q.poll();

							for (int k = 0; k < 8; k++) {
								int ny = now[0] + dy[k];
								int nx = now[1] + dx[k];
								if(0<=ny && ny<Y && 0<=nx && nx<X && board[ny][nx] != 0){
									board[ny][nx] = 0;
									q.add(new int[]{ny, nx});
								}
							}
						}

					}
				}
			}
			sb.append(cnt+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
