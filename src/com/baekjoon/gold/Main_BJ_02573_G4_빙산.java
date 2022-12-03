package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_02573_G4_빙산 {

	static int Y, X;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map, minus;
	static boolean zero;

	static boolean check() {
		ArrayList<int[]> vingsan = new ArrayList<>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] != 0) {
					vingsan.add(new int[] { i, j });
				}
			}
		}
		// 빙산이 하나도 없다면
		if (vingsan.size() == 0) {
			zero = true;
			return false;
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { vingsan.get(0)[0], vingsan.get(0)[1] });

		boolean[][] visited = new boolean[Y][X];
		visited[q.peek()[0]][q.peek()[1]] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
					if (0 <= ny && ny < Y && 0 <= nx && nx < X && !visited[ny][nx] && map[ny][nx] != 0) {
						visited[ny][nx] = true;
						q.add(new int[] { ny, nx });
					}
				}
			}
		}

		for (int[] v : vingsan) {
			// 모든 빙산중에 위의 bfs를 지나며 방문하지 못한 빙산이 있다면 빙산이 나누어졌다는 것!!
			if (!visited[v[0]][v[1]]) {
				return false;
			}
		}

		return true;
	}

	// 녹는다!
	static void melt(int y, int x) {
		int cnt = 0;
		
		//현재 빙산의 상하좌우의 0의 개수를 세어줍니다. 
		for (int j = 0; j < 4; j++) {
			int ny = y + dy[j];
			int nx = x + dx[j];
			if (0 <= ny && ny < Y && 0 <= nx && nx < X && map[ny][nx] == 0) {
				cnt++;
			}
		}
		
		//같은 크기를 가지는 minus 배열의 y,x 좌표에 해당 빙산이 얼마나 녹아야 하는지 표시해줍니다.
		minus[y][x] = cnt;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		zero = false;

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int t = 0;
		while (check()) {
			minus = new int[Y][X];
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if(map[i][j] != 0) melt(i, j);
				}
			}
			
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if(map[i][j] != 0) map[i][j] = map[i][j] - minus[i][j] >= 0 ? map[i][j] - minus[i][j] : 0;
				}
			}
			t++;
		}
		
		if(zero) System.out.println(0);
		else System.out.println(t);
		
	}
}
