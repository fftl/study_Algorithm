package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_02583_S1_영역구하기 {
	static int M, N, K;
	static boolean[][] board;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			insert(sy,sx,ey,ex);
		}

//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				if(board[i][j]) sb.append(1+" ");
//				else sb.append(0+" ");
//			}
//			sb.append("\n");
//		}
//		System.out.println(sb.toString());

		PriorityQueue<Integer> res = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!board[i][j]){
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[]{i, j});

					board[i][j] = true;

					int cnt = 1;
					while(!q.isEmpty()){
						int[] now = q.poll();
						for (int k = 0; k < 4; k++) {
							int ny = now[0] + dy[k];
							int nx = now[1] + dx[k];

							if(0<=ny && ny<M && 0<=nx && nx<N && !board[ny][nx]){
								board[ny][nx] = true;
								q.add(new int[]{ny,nx});
								cnt++;
							}
						}
					}

					res.add(cnt);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(res.size()+"\n");

		while(!res.isEmpty()){
			sb.append(res.poll()+" ");
		}

		System.out.println(sb.toString());
	}

	static void insert(int sy, int sx, int ey, int ex) {
		for (int i = sy; i < ey; i++) {
			for (int j = sx; j < ex; j++) {
				board[i][j] = true;
			}
		}
	}
}
