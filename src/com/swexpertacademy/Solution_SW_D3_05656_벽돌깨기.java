package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SW_D3_05656_벽돌깨기 {

	static int Y, X, N, min;
	static int[][] map;
	static int[][] copy;
	static int[] per;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[] visited;
	static boolean[][] qvisited;

	static void down() {
		for (int i = 0; i < X; i++) {
			Queue<Integer> q = new LinkedList<>();
			for (int j = Y - 1; j >= 0; j--) {
				if (copy[j][i] != 0) {
					q.add(copy[j][i]);
					copy[j][i] = 0;
				}
			}

			for (int j = Y - 1; j >= 0; j--) {
				if (!q.isEmpty()) {
					copy[j][i] = q.poll();
				} else {
					break;
				}
			}
		}
	}

	static void remove() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if (qvisited[i][j])
					copy[i][j] = 0;
			}
		}
	}

	static void go(int k) {
		int y = -1;
		int x = k;
		// 위에서 부터 0이 아닌 수를 찾습니다.
		for (int i = 0; i < Y; i++) {
			if (copy[i][k] != 0) {
				y = i;
				break;
			}
		}
		if(y == -1) return;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { y, x });
		qvisited[y][x] = true;
		
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				int u = copy[now[0]][now[1]];
				for (int j = 0; j < 4; j++) {
					for (int w = 0; w < u; w++) {
						int ny = now[0] + dy[j] * w;
						int nx = now[1] + dx[j] * w;

						// map 안에 있으며 벽돌이 있어야 하며 방문하지 않은 곳!
						if (0 <= ny && ny < Y && 0 <= nx && nx < X && copy[ny][nx] != 0 && !qvisited[ny][nx]) {
							q.add(new int[] { ny, nx });
							qvisited[ny][nx] = true;
						}
					}
				}
			}
		}
	}
	
	static void mapCopy() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	static int wallCnt() {
		int cnt = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(copy[i][j] != 0) cnt++;
			}
		}
		return cnt;
	}
	
	static int print() {
		int cnt = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
		return cnt;
	}

	static void permutation(int n) {
		if (n == N) {
			copy = new int[Y][X];
			mapCopy();
			for (int i = 0; i < per.length; i++) {
				qvisited = new boolean[Y][X];
				go(per[i]);
				remove();
				down();
			}
			min = Math.min(wallCnt(), min);
			return;
		}

		for (int i = 0; i < X; i++) {
			if (visited[i])
				continue;
			per[n] = i;
			permutation(n + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sw_input_5656.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			map = new int[Y][X];
			per = new int[N];
			visited = new boolean[X];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < Y; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < X; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			permutation(0);
			System.out.println("#"+tc+" "+min);
		}
	}

}

