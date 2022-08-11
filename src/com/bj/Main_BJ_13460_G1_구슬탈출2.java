package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/board/view/90094 반례
public class Main_BJ_13460_G1_구슬탈출2 {
	static int N, M, result;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] blue, red, end;
	static char[][] board;
	static boolean[][] visited;

	static void dfs(int y, int x, int cnt) {
		if (result == -1) {
			return;
		}

		if (cnt > 10) {
			result = -1;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
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
						ny = ny - dy[i];
						nx = nx - dx[i];
						
						if(blue[0] == ny && blue[1] == nx) {
							continue;
						}
						
						board[ny][nx] = 'B';
						board[blue[0]][blue[1]] = '.';
						blue[0] = ny;
						blue[1] = nx;

						ny = ny - dy[i];
						nx = nx - dx[i];
						board[ny][nx] = 'R';
						board[red[0]][red[1]] = '.';
						red[0] = ny;
						red[1] = nx;
						dfs(ny, nx, cnt+1);
						
					} else { //빨강공이 가는길에 블루공이 없었다면, 블루공도 따로 이동을 시켜줘야합니다.
						ny = ny - dy[i];
						nx = nx - dx[i];
						board[ny][nx] = 'R';
						board[red[0]][red[1]] = '.';
						red[0] = ny;
						red[1] = nx;

						// ## 블루공을 알아서 이동시켜줍니다!
						int bluey = blue[0] + dy[i];
						int bluex = blue[0] + dx[i];
						// 블루공도 이동시켜줍니다.
						while (board[bluey][bluex] == '.') {
							int nexty = bluey + dy[i];
							int nextx = bluex + dx[i];
							if (0 <= nexty && nexty < N && 0 <= nextx && nextx < M) {
								bluey = nexty;
								bluex = nextx;
							}
						}
						
						if (board[bluey][bluex] == '#') {
							bluey = bluey - dy[i];
							bluex = bluex - dx[i];
							board[bluey][bluex] = 'B';
							board[blue[0]][blue[1]] = '.';
							blue[0] = bluey;
							blue[1] = bluex;
						}
						
						if (board[bluey][bluex] == 'O') {
							if (findBlue)
								result = -1;
							return;
						}
						dfs(ny, nx, cnt+1);
						//블루공 이동!!
					}
					dfs(ny, nx, cnt + 1);
					return;
				}

				if (board[ny][nx] == 'O') {
					if (findBlue)
						result = -1;
					else
						result = Math.min(result, cnt + 1);
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
		dfs(red[0], red[1], 0);
		
		if(result!=Integer.MAX_VALUE)  System.out.println(result);
		else System.out.println(-1);
	}

}
