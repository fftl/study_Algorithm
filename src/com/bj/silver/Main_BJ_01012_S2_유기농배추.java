package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01012_S2_유기농배추 {
	static int M, N, K, result; // M-가로, N-세로, K개수
	static boolean[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	//방문한 땅은 false로 표시해주어 다시 방문하지 않도록 하고,
	//상하좌우 네 방향중 갈수 있는 방향(배추가 심어져있는 곳)을 찾아서 이동해줍니다.
	static void dfs(int y, int x) {
		map[y][x] = false;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (0 <= ny && ny < N && 0 <= nx && nx < M) {
				if (map[ny][nx])
					dfs(ny, nx);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		//데이터 입력받기
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			result = 0;

			//땅의 크기만큼 boolean 이중배열을 만들어줍니다.
			map = new boolean[N][M];
			
			//땅에 심어진 배추의 위치에 true로 표시를 해줍니다.
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = true;
			}

			//0, 0 부터 하나씩 이동하며 배추가 심어진 땅이 나온다면 dfs를 실행해줍니다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]) {
						dfs(i, j);
						result++;
					}
				}
			}

			System.out.println(result);

		}

	}

}
