package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
6 8 1
3 2 6 3 1 2 9 7
9 7 8 2 1 4 5 3
5 9 2 1 9 6 1 8
2 1 3 8 6 3 9 2
1 3 2 8 7 9 2 1
4 5 1 9 8 2 1 3
1
*/
public class Main_BJ_16935_S1_배열돌리기3 {
	static int N, M, R;
	static int[][] board, copy;

	static void run(int k, int y, int x) {
		int halfN = y / 2;
		int halfM = x / 2;
		switch (k) {

		case 1:
			copy = new int[y][x];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					copy[y - 1 - i][j] = board[i][j];
				}
			}
			break;
		case 2:
			copy = new int[y][x];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					copy[j][x - 1 - i] = board[j][i];
				}
			}
			break;
		case 3:
			copy = new int[x][y];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					copy[j][y - 1 - i] = board[i][j];
				}
			}
			break;
		case 4:
			copy = new int[x][y];
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					copy[x - 1 - j][i] = board[i][j];
				}
			}
			break;
		case 5:
			copy = new int[y][x];
			// 1번 -> 2번
			for (int i = 0; i < halfN; i++) {
				for (int j = 0; j < halfM; j++) {
					copy[i][j + halfM] = board[i][j];
				}
			}

			// 2번 -> 3번
			for (int i = 0; i < halfN; i++) {
				for (int j = halfM; j < x; j++) {
					copy[i + halfN][j] = board[i][j];
				}
			}

			// 3번 -> 4번
			for (int i = halfN; i < y; i++) {
				for (int j = halfM; j < x; j++) {
					copy[i][j - halfM] = board[i][j];
				}
			}

			// 4번 -> 1번
			for (int i = halfN; i < y; i++) {
				for (int j = 0; j < halfM; j++) {
					copy[i - halfN][j] = board[i][j];
				}
			}

			break;
		case 6:
			copy = new int[y][x];
			// 1번 -> 4번
			for (int i = 0; i < halfN; i++) {
				for (int j = 0; j < halfM; j++) {
					copy[i + halfN][j] = board[i][j];
				}
			}

			// 4번 -> 3번
			for (int i = halfN; i < y; i++) {
				for (int j = 0; j < halfM; j++) {
					copy[i][j + halfM] = board[i][j];
				}
			}

			// 3번 -> 2번
			for (int i = halfN; i < y; i++) {
				for (int j = halfM; j < x; j++) {
					copy[i - halfN][j] = board[i][j];
				}
			}

			// 2번 -> 1번
			for (int i = 0; i < halfN; i++) {
				for (int j = halfM; j < x; j++) {
					copy[i][j - halfM] = board[i][j];
				}
			}

			break;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			int key = Integer.parseInt(st.nextToken());
			run(key, board.length, board[0].length);

			board = new int[copy.length][copy[0].length];

			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k < board[0].length; k++) {
					board[j][k] = copy[j][k];
				}
			}
		}

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
