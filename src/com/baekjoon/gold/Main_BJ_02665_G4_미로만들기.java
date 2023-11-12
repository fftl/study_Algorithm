package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_BJ_02665_G4_미로만들기 {
	static int N;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[][] board = new char[N][N];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});

		boolean[][] visited = new boolean[N][N];
		visited[0][0] = true;

		pq.add(new int[]{0,0,0});

		int res = 0;
		while(!pq.isEmpty()){
			int[] now = pq.poll();
			//끝점에 도달하면
			if(now[0] == N-1 && now[1] == N-1){
				res = now[2];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]){
					visited[ny][nx] = true;
					if(board[ny][nx] == '0'){
						pq.add(new int[]{ny, nx, now[2]+1});
					} else {
						pq.add(new int[]{ny, nx, now[2]});
					}
				}
			}
		}

		System.out.println(res);
	}
}
