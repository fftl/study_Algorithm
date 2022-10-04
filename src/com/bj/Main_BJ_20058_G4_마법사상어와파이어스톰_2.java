package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_20058_G4_마법사상어와파이어스톰_2 {

	static int N, Q, n;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;

	static void turn(int k) {
		int m = (int) Math.pow(2, k);
		int ms = m / 2;
		int[][] copy = new int[n][n];

		// 각 격자의 시작점을 찾습니다.
		for (int i = 0; i < n; i += m) {
			for (int j = 0; j < n; j += m) {
				
				for (int i2 = i, x=j+m-1; i2 < i+m; i2++, x--) {
					for (int j2 = j, y=i; j2 < j+m; j2++, y++) {
						copy[y][x] = map[i2][j2];
					}
				}
				
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}

	static void melt() {
		boolean[][] check = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0)
					continue;

				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if (0 <= ny && ny < n && 0 <= nx && nx < n && map[ny][nx] > 0) {
						cnt++;
					}
				}
				if (cnt < 3)
					check[i][j] = true;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j])
					map[i][j] -= 1;
			}
		}
	}

	static int cntAll() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	static int cntMax() {
		int maxCnt = 0;
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					int cnt = 0;
					q.add(new int[] { i, j });
					visited[i][j] = true;

					while (!q.isEmpty()) {
						int size = q.size();
						for (int k = 0; k < size; k++) {
							cnt++;
							int[] now = q.poll();

							for (int u = 0; u < 4; u++) {
								int ny = now[0] + dy[u];
								int nx = now[1] + dx[u];
								if (0 <= ny && ny < n && 0 <= nx && nx < n && map[ny][nx] > 0 && !visited[ny][nx]) {
									q.add(new int[] { ny, nx });
									visited[ny][nx] = true;
								}
							}
						}
					}

					maxCnt = Math.max(cnt, maxCnt);
				}
			}
		}

		return maxCnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		n = (int) Math.pow(2, N);
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int k = Integer.parseInt(st.nextToken());
			turn(k);
			melt();
		}

		System.out.println(cntAll());
		System.out.println(cntMax());
	}

	static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
