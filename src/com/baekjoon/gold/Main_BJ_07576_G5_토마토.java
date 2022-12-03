package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_07576_G5_토마토 {

	static int Y, X, before;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static boolean nope;

	static boolean check() {
		boolean key = true;
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				sum += map[i][j];
				if (map[i][j] == 0) {
					key = false;
				}
			}
		}
		
		if(sum == before) {
			nope = true;
		}
		
		before = sum;
		return key;
	}

	static void go(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (0 <= ny && ny < Y && 0 <= nx && nx < X && map[ny][nx] == 0) {
				map[ny][nx] = 1;
				visited[ny][nx] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		if (check()) {
			System.out.println(0);
			return;
		}
		
		nope = false;
		before = 0;
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				before += n;
			}
		}

		int day = 0;
		do{
			if(nope) {
				System.out.println(-1);
				return;
			}
			visited = new boolean[Y][X];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						go(i, j);
					}
				}
			}
			day++;
		}while (!check());

		System.out.println(day);
	}
}
