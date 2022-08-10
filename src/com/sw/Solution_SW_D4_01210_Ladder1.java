package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D4_01210_Ladder1 {

	static int[][] board;
	static boolean end = false;
	static int result;

	public static void go(int y, int x, int s) {
		if (y == 0) {
			result = x;
			return;
		}

		if (s == 0) {
			if (0 <= x - 1) {
				if (board[y][x - 1] == 1) {
					go(y, x - 1, -1);
					return;
				}
			}

			if (x + 1 < 100) {
				if (board[y][x + 1] == 1) {
					go(y, x + 1, 1);
					return;
				}
			}

			if (board[y - 1][x] == 1) {
				go(y - 1, x, 0);
				return;
			}

		} else if (s == -1) {
			if (0 <= x - 1) {
				if (board[y][x - 1] == 1) {
					go(y, x - 1, -1);
				} else {
					go(y - 1, x, 0);
				}
			} else {
				go(y - 1, x, 0);
			}
		} else if (s == 1) {
			if (x + 1 < 100) {
				if (board[y][x + 1] == 1) {
					go(y, x + 1, 1);
				} else {
					go(y - 1, x, 0);
				}
			} else {
				go(y - 1, x, 0);
			}
		}

	}

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/sw_input_1210.txt")); // input 가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			board = new int[100][100];
			end = false;
			result = -1;

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				if (board[99][i] == 2) {
					go(99, i, 0);
				}
			}
			System.out.println("#" + tc + " " + result);
		}

	}
}