package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01388_S4_바닥장식 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) continue;

				char now = board[i][j];
				int next = -1;
				if(now == '-'){
					next = j;
					while(!visited[i][next] && board[i][next] == '-') {
						visited[i][next] = true;
						next++;
						if(next>=M) break;
					}
				} else {
					next = i;
					while(!visited[next][j] && board[next][j] == '|') {
						visited[next][j] = true;
						next++;
						if(next>=N) break;
					}
				}

				result++;
			}
		}

		System.out.println(result);
	}
}
