package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01780_S2_종이의개수 {
	static int N, res1, res2, res3;
	static int[][] board;

	static void dep(int n, int y, int x) {
		if (n == 1) {
			int now = board[y][x];
			if (now == -1)
				res1++;
			else if (now == 0)
				res2++;
			else
				res3++;
			return;
		}

		// 세개의 키로 만약 두개 이상이 true가 되면 종이를 만들 수 없다!
		boolean mone = false;
		boolean zero = false;
		boolean one = false;
		boolean able = true;

		run: for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				int now = board[i][j];
				if (now == -1)
					mone = true;
				else if (now == 0)
					zero = true;
				else
					one = true;
				// 만약 수가 두개 이상일 경우에는 종이를 만들 수 없으므로 탐색을 바로 종료해버립니다.
				if ((mone && zero) || (zero && one) || (mone && one)) {
					able = false;
					break run;
				}
			}
		}

		if (able) {
			if (mone)
				res1++;
			else if (zero)
				res2++;
			else
				res3++;

			// 이번 사이즈에서 종이를 만들 수 없다면
		} else {
			int half = n / 3;
			for (int i = y; i < y + n; i += half) {
				for (int j = x; j < x + n; j += half) {
					dep(half, i, j);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dep(N, 0, 0);

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);

	}
}
