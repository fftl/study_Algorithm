package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_21610_G5_마법사상어와비바라기 {

	// 구름 이동하기
	static void moveCloud(int d, int s) {
		for (int i = 0; i < cd.size(); i++) {
			Cloud c = cd.get(i);

			int ny = c.y + dy[d] * s;
			int nx = c.x + dx[d] * s;

			if (ny < 0)
				ny = N + (ny % N);
			if (nx < 0)
				nx = N + (nx % N);
			if (N <= ny)
				ny = ny % N;
			if (N <= nx)
				nx = nx % N;

			c.y = ny;
			c.x = nx;
		}
	}

	// 비를 내리기( 구름칸 물 +1 )
	static void raining() {
		disappear = new boolean[N][N];
		for (int i = 0; i < cd.size(); i++) {
			Cloud c = cd.get(i);
			board[c.y][c.x] += 1;
			disappear[c.y][c.x] = true;
		}
	}

	// 물복사( 물이 증가한 칸의 대각선들에 물이 존재하는 칸의 갯수만큼 물의 양이 증가 )
	// 물의 양이 2 이상인 모든 칸에 구름 생성, 물의 양이 2 줄어듬,(3번 위치는 제외!)
	static void waterCopy() {
		for (int i = 0; i < cd.size(); i++) {
			Cloud c = cd.get(i);
			int cnt = 0;
			for (int j = 1; j < 8; j += 2) {
				int ny = c.y + dy[j];
				int nx = c.x + dx[j];

				// 대각선 네 방향을 보면서 물이 있는 갯수를 셉니다.
				if (0 <= ny && ny < N && 0 <= nx && nx < N) {
					if (board[ny][nx] > 0)
						cnt++;
				}
			}
			board[c.y][c.x] += cnt;
		}
		cd.clear();
	}

	// 물을 2 이상 가진 칸에 구름을 만들어줍니다.
	static void newCloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] >= 2 && !disappear[i][j]) {
					cd.add(new Cloud(i, j));
					board[i][j] -= 2;
				}
			}
		}
	}

	static void getResult() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += board[i][j];
			}
		}
	}

	static int N, M, result;
	static int[][] board;
	static boolean[][] disappear;
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static ArrayList<Cloud> cd;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cd = new ArrayList<>();
		cd.add(new Cloud(N - 1, 0));
		cd.add(new Cloud(N - 1, 1));
		cd.add(new Cloud(N - 2, 0));
		cd.add(new Cloud(N - 2, 1));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			moveCloud(d, s);
			raining();
			waterCopy();
			newCloud();
		}
		
		getResult();
		System.out.println(result);
	}

	static class Cloud {
		int y, x;

		public Cloud(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Cloud [y=" + y + ", x=" + x + "]";
		}
	}
}
