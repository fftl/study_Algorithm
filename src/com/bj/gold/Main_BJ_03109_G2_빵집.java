package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_03109_G2_빵집 {
	static int N, M, result;
	static boolean[][] visited;
	static char[][] board;
	static int[] dy = { -1, 0, 1 };
	static int[] dx = { 1, 1, 1 };

	static boolean run(int y, int x) {
		if(x == M-1) return true;
		
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			//다음에 이동할 곳이 board 안이고, 아직 방문하지 않았고, 'x'가 아니라면 이동합니다.
			if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && board[ny][nx] != 'x') {
				visited[ny][nx] = true;
				if(run(ny, nx)) return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {

		//데이터를 입력받습니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		visited = new boolean[N][M];
		result = 0;

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		//각 시작점에서 끝까지 도달 할 수 있는지 확인합니다.
		for (int i = 0; i < N; i++) {
			if(run(i, 0)) {
				result++;
			}
		}
		
		System.out.println(result);
	}

}
