package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_07576_G5_토마토2 {

	static int Y, X, before;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static boolean nope;

	//최초의 체크를 해줍니다.
	//시작할때 부터 0이 하나도 없다면 탐색을 끝냅니다.
	static boolean check() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[Y][X];

		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[Y][X];
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 1) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}
		
		if (check()) {
			System.out.println(0);
			return;
		}

		int day = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];

					if (0 <= ny && ny < Y && 0 <= nx && nx < X && map[ny][nx] == 0) {
						map[ny][nx] = 1;
						q.add(new int[] { ny, nx });
						visited[ny][nx] = true;
					}
				}
			}
			day++;
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(day - 1);
	}
}
