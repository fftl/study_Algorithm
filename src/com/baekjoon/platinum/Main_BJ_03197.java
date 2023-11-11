package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_03197_P5_백조의호수 {
	static int Y, X;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean end;
	static char[][] board;
	static boolean[][] visited;
	static int sy1, sx1, sy2, sx2;
	static Queue<int[]> que, swanQ;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new char[Y][X];
		que = new LinkedList<>();
		swanQ = new LinkedList<>();

		for (int i = 0; i < Y; i++) {
			board[i] = br.readLine().toCharArray();
		}

		// 각각의 요소들의 위치를 찾습니다.
		initData();

		// 종료조건을 확인합니다.
		end = false;

		// 최초의 상태에서 종료가 가능한지 확인합니다.
		bfs();
		if (end)
			System.out.println(0);
		else {
			// 종료가 되지 않았다면 며칠이 지났는지 시작합니다.
			int cnt = 0;
			while (!end) {
				cnt++;
				melt();
				bfs();
			}
			System.out.println(cnt);
		}
	}

	public static void melt() {
		int size = que.size();

		for (int i = 0; i < size; i++) {
			int[] now = que.poll();

			for (int j = 0; j < 4; j++) {
				int ny = now[0] + dy[j];
				int nx = now[1] + dx[j];
				if (0 <= ny && ny < Y && 0 <= nx && nx < X) {
					if (board[ny][nx] == 'X') {
						board[ny][nx] = '.';
						que.add(new int[] { ny, nx });
					}
				}

			}
		}
	}

	// 백조의 위치를 찾아줍니다.
	public static void initData() {
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (board[i][j] == 'L') {
					arr.add(new int[] { i, j });
					que.add(new int[] { i, j });

				} else if (board[i][j] != 'X') {
					que.add(new int[] { i, j });
				}
			}
		}

		sy1 = arr.get(0)[0];
		sx1 = arr.get(0)[1];
		sy2 = arr.get(1)[0];
		sx2 = arr.get(1)[1];

		swanQ.add(new int[] { sy1, sx1 });
		visited = new boolean[Y][X];
		visited[sy1][sx1] = true;

	}

	public static void bfs() {
		Queue<int[]> nextQ = new LinkedList<>();

		run: while (!swanQ.isEmpty()) {
			int[] now = swanQ.poll();

			if (now[0] == sy2 && now[1] == sx2) {
				end = true;
				break run;
			}

			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx]) {
					visited[ny][nx] = true;
					if (board[ny][nx] == 'X') {
						nextQ.add(new int[] { ny, nx });
					} else {
						swanQ.add(new int[] { ny, nx });
					}
				}
			}
		}

		swanQ = nextQ;
	}
}
