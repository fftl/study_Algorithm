package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_15683_G4_감시{
	static int Y, X, minRes, E;
	static int[][] board, copyBoard;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static ArrayList<Pair> camera;

	public static class Pair {
		int y, x, k, d;

		public Pair(int y, int x, int k, int d) {
			this.y = y;
			this.x = x;
			this.k = k;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Pair [y=" + y + ", x=" + x + ", k=" + k + ", d=" + d + "]";
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new int[Y][X];
		minRes = Y * X; // 최소값을 구해야 하기 때문에 초기에는 최대 값으로 줍니다.
		camera = new ArrayList<>();

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num > 0 && num < 5) {
					camera.add(new Pair(i, j, num, 0));
				}
				board[i][j] = num;
			}
		}

		// 5번은 모든 방향이므로 dfs에 포함시키기에는 비효율적입니다.
		// 미리 5번은 board에 표시해준 뒤 해당 board를 이용해 dfs를 시작하도록 합니다.
		copyBoard = copyBoard();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (board[i][j] == 5) {
					look(new Pair(i, j, 5, 0));
				}
			}
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				board[i][j] = copyBoard[i][j];
			}
		}

		E = camera.size();
		dfs(0);

		System.out.println(minRes);
	}

	static boolean isRange(int y, int x) {
		return (0 <= y && y < Y && 0 <= x && x < X);
	}

	static void lookRun(int y, int x, int d) {
		int ny = y + dy[d];
		int nx = x + dx[d];

		while (isRange(ny, nx)) {
			if (copyBoard[ny][nx] == 6)
				break; // 벽을 만나면 바로 종료합니다.
			else { // 벽이 아니고
				if (copyBoard[ny][nx] == 0) { // 아직 감시되고 있지 않다면
					copyBoard[ny][nx] = -1;
				}
			}
			ny = ny + dy[d];
			nx = nx + dx[d];
		}
	}

	// y,x 좌표에서 k를 바라보고 있다는 표시를 해줍니다.
	static void look(Pair pair) {
		int y = pair.y;
		int x = pair.x;
		int k = pair.k;
		int d = pair.d;

		switch (k) {
			case 1:
				lookRun(y, x, (d + 1) % 4);
				break;
			case 2:
				lookRun(y, x, (d + 1) % 4);
				lookRun(y, x, (d + 3) % 4);
				break;
			case 3:
				lookRun(y, x, d);
				lookRun(y, x, (d + 1) % 4);
				break;
			case 4:
				lookRun(y, x, d);
				lookRun(y, x, (d + 1) % 4);
				lookRun(y, x, (d + 3) % 4);
				break;

			case 5: // 모든방향! 회전해도 변화가 없기에 최초에 그냥 일괄처리를 합니다.
				lookRun(y, x, d);
				lookRun(y, x, (d + 1) % 4);
				lookRun(y, x, (d + 2) % 4);
				lookRun(y, x, (d + 3) % 4);
				break;
		}
	}

	// 각 카메라 배치마다 새로운 맵을 그려줘야 하기 때문에 board를 복사해줍니다.
	static int[][] copyBoard() {
		int[][] copy = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}

	static void dfs(int cnt) {
		// 카메라 세개를 다 뽑았다면 연산을 시작합니다.
		if (cnt == E) {
			copyBoard = copyBoard();
			for (int i = 0; i < camera.size(); i++) {
				look(camera.get(i));
			}
			minCheck();
			return;
		}

		/**
		 * 틀린 코드 for (int i = cnt; i < E; i++) { for(int j=1; j<=5; j++) {
		 * camera.get(cnt).k = j; dfs(cnt+1); } }
		 */

		for (int j = 0; j <= 3; j++) {
			camera.get(cnt).d = j;
			dfs(cnt + 1);
		}
	}

	static void minCheck() {
		int cnt = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (copyBoard[i][j] == 0)
					cnt++;
			}
		}
		minRes = Math.min(cnt, minRes);
	}

	static void print() {
		for (int i = 0; i < Y; i++) {
			String str = "";
			for (int j = 0; j < X; j++) {
				str += copyBoard[i][j] + " ";
			}
			System.out.println(str);
		}

	}
}
