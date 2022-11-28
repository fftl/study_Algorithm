package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16926_S1_배열돌리기1 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int w = Math.min(N, M);

		int[][] board = new int[N][M];

		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// C만큼 반복!!
		while (0 < C) {
			C--;
			// 안쪽 네모를 들어가는 것을 dep으로 표현!
			for (int dep = 0; dep < w / 2; dep++) {
				int y = 0 + dep;
				int x = 0 + dep;
				int start = board[y][x];

				while (x + 1 < M - dep) {
					board[y][x] = board[y][x + 1];
					x++;
				}

				while (y + 1 < N - dep) {
					board[y][x] = board[y + 1][x];
					y++;
				}
				while (x - 1 >= 0 + dep) {
					board[y][x] = board[y][x - 1];
					x--;
				}

				while (y - 1 >= 0 + dep) {
					board[y][x] = board[y - 1][x];
					y--;
				}

				// 가장 시작부분은 start에 담아두었다가 그대로 넣어줍니다!
				board[y + 1][x] = start;
			}
		}

		// 출력을 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString().trim());
	}
}
