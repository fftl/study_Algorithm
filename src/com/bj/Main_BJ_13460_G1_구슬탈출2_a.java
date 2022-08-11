package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13460_G1_구슬탈출2_a {
	static int N, M, result;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] blue, red, end;
	static char[][] board;
	static boolean[][] visited;

	static void dfs(int ry, int rx, int by, int bx, int cnt) {
		if (result == -1) {
			return;
		}

		if (cnt > 10) {
			result = -1;
			return;
		}

		for (int i = 0; i < 4; i++) {
			System.out.println("big for"+cnt+"------------------------------- ");
			System.out.println(i);
			System.out.println(ry + "," + rx + "," + by + "," + bx + "," + cnt);
			int ny = ry + dy[i];
			int nx = rx + dx[i];
			if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]) {
				if (board[ny][nx] == '#') {
					continue;
				}

				boolean findBlue = false;
				while (board[ny][nx] == '.' || board[ny][nx] == 'B') {
					visited[ny][nx] = true;
					if (board[ny][nx] == 'B')
						findBlue = true;

					int nexty = ny + dy[i];
					int nextx = nx + dx[i];
					if (0 <= nexty && nexty < N && 0 <= nextx && nextx < M) {
						ny = nexty;
						nx = nextx;
					}
				}

				if (board[ny][nx] == '#') {
					if (findBlue) { // 가는길에 블루공이 있었다면, 마지막길
						int newby = ny - dy[i];
						int newbx = nx - dx[i];

						// 이동하지 않았다! red blue # 같은 배열일 경우..
						if (blue[0] == by && blue[1] == bx) {
							continue;
						}

						int newry = by - dy[i];
						int newrx = bx - dx[i];
						dfs(newry, newrx, newby, newbx, cnt + 1);

					} else { // 빨강공이 가는길에 블루공이 없었다면, 블루공도 따로 이동을 시켜줘야합니다.
						int newry = by - dy[i];
						int newrx = bx - dx[i];

						// ## 블루공을 알아서 이동시켜줍니다!
						int bluey = by + dy[i];
						int bluex = bx + dx[i];
						
						int newby = by;
						int newbx = bx;
						// 블루공도 이동시켜줍니다.
						while (board[bluey][bluex] == '.') {
							int nexty = bluey + dy[i];
							int nextx = bluex + dx[i];
							if (0 <= nexty && nexty < N && 0 <= nextx && nextx < M) {
								bluey = nexty;
								bluex = nextx;
							}
						}

						if (board[bluey][bluex] == '#' || bluey == ry && bluex == rx) {
							newby = bluey - dy[i];
							newbx = bluex - dx[i];
						}

						if (board[bluey][bluex] == 'O') {
							if (findBlue) return;
						}
						
						System.out.println("#에 도착 not blue");
						dfs(newry, newrx, newby, newbx, cnt + 1);
						// 블루공 이동!!
					}
				}

				if (board[ny][nx] == 'O') {
					if (findBlue) {
						result = -1;
					} else {
						result = Math.min(result, cnt + 1);
					}
					return;
				}
			}
		}
	}

	// 각각의 포인트의 위치를 찾아줍니다.
	static void findPoint() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'B') {
					blue = new int[] { i, j };
				} else if (board[i][j] == 'R') {
					red = new int[] { i, j };
				} else if (board[i][j] == 'O') {
					end = new int[] { i, j };
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // y
		M = Integer.parseInt(st.nextToken()); // x

		board = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		findPoint();

		result = Integer.MAX_VALUE;
		dfs(red[0], red[1], blue[0], blue[1], 0);

		if (result != Integer.MAX_VALUE)
			System.out.println(result);
		else
			System.out.println("test123123");
			System.out.println(-1);
	}

}
