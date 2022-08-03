package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D3_1873_상호의배틀필드 {
	static int H, W, tanky, tankx, tankr;
	static String[][] board;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static String[] tk = { "^", "v", "<", ">" };

	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}

	// 탱크의 위치와 방향을 찾아줍니다!
	static void findTank() {
		end: for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (board[i][j].equals("^")) {
					tankr = 0;
					tanky = i;
					tankx = j;
					break end;
				} else if (board[i][j].equals("v")) {
					tankr = 1;
					tanky = i;
					tankx = j;
					break end;
				} else if (board[i][j].equals("<")) {
					tankr = 2;
					tanky = i;
					tankx = j;
					break end;
				} else if (board[i][j].equals(">")) {
					tankr = 3;
					tanky = i;
					tankx = j;
					break end;
				}
			}
		}
	}

	static void go(String s) {
		int shty = tanky;
		int shtx = tankx;
		if (s.equals("S")) {
			while (true) {
				int ny = shty + dy[tankr];
				int nx = shtx + dx[tankr];
				if (0 <= ny && ny < H && 0 <= nx && nx < W) {
					if (board[ny][nx].equals(".") || board[ny][nx].equals("-")) {
						shty = ny;
						shtx = nx;
					} else if (board[ny][nx].equals("*")) {
						board[ny][nx] = ".";
						break;
					} else {
						break;
					}
				} else {
					break;
				}
			}
		} else {
			if (s.equals("U")) {
				int ny = tanky + dy[0];
				int nx = tankx + dx[0];
				if (0 <= ny && ny < H && 0 <= nx && nx < W) {
					if (board[ny][nx].equals(".")) {
						board[tanky][tankx] = ".";
						tanky = ny;
						tankx = nx;
						board[tanky][tankx] = tk[0];
					}
				}
				board[tanky][tankx] = tk[0];
				tankr = 0;

			} else if (s.equals("D")) {
				int ny = tanky + dy[1];
				int nx = tankx + dx[1];
				if (0 <= ny && ny < H && 0 <= nx && nx < W) {
					if (board[ny][nx].equals(".")) {
						board[tanky][tankx] = ".";
						tanky = ny;
						tankx = nx;
						board[tanky][tankx] = tk[1];
					}
				}
				board[tanky][tankx] = tk[1];
				tankr = 1;
				
			} else if (s.equals("L")) {
				int ny = tanky + dy[2];
				int nx = tankx + dx[2];
				if (0 <= ny && ny < H && 0 <= nx && nx < W) {
					if (board[ny][nx].equals(".")) {
						board[tanky][tankx] = ".";
						tanky = ny;
						tankx = nx;
						board[tanky][tankx] = tk[2];
					}
				}
				board[tanky][tankx] = tk[2];
				tankr = 2;
				
			} else {
				int ny = tanky + dy[3];
				int nx = tankx + dx[3];
				if (0 <= ny && ny < H && 0 <= nx && nx < W) {
					if (board[ny][nx].equals(".")) {
						board[tanky][tankx] = ".";
						tanky = ny;
						tankx = nx;
						board[tanky][tankx] = tk[3];
					}
				}
				board[tanky][tankx] = tk[3];
				tankr = 3;
			}
		}
	}

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/sw_input_1873.txt")); // input 가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			tanky = -1;
			tankx = -1;
			tankr = -1;

			board = new String[H][W];

			for (int i = 0; i < H; i++) {
				board[i] = br.readLine().split("");
			}

			findTank(); // 탱크의 현재 위치를 찾아줍니다.

			int cmdCnt = Integer.parseInt(br.readLine());
			String cmd = br.readLine();
			for (int i = 0; i < cmdCnt; i++) {
				String s = Character.toString(cmd.charAt(i));
				go(s);
			}

			System.out.print("#" + tc + " ");
			print();
		}

	}
}
