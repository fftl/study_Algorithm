package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_10026_G5_적록색약 {

	static int N;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visited;

	static void dfs(int y, int x, boolean key) {
		if (key) { //정상시야인 경우 각각의 색 체크해서 뻗어갑니다.
			visited[y][x] = true;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]) {
					if(map[y][x] == map[ny][nx]) {
						dfs(ny, nx, key);
					}
				}
			}
		} else { //적록색약인 경우!
			visited[y][x] = true;
			char c = map[y][x];
			
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]) {
					//만약 기존 색상이 R 이라면 R또는 G모두 뻗어갈 수 있다!
					//그리고 반대의 경운인 G 일때도 R과 G모두 뻗어갈 수 있다.
					//마지막으로 B일때는 B만 뻗어갈 수 있다.
					if(c=='R' && (map[ny][nx] == 'R' || map[ny][nx] == 'G')){
						dfs(ny, nx, key);
					}
					if(c=='G' && (map[ny][nx] == 'R' || map[ny][nx] == 'G')){
						dfs(ny, nx, key);
					}
					if(c=='B' && map[ny][nx] == 'B') {
						dfs(ny, nx, key);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int cnt1 = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, true);
					cnt1++;
				}
			}
		}
		
		int cnt2 = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, false);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}
}
