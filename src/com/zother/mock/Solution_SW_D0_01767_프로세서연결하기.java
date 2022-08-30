package com.zother.mock;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D0_01767_프로세서연결하기 {

	static int N, cnt, len;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static ArrayList<int[]> arr;
	static boolean[][] visited;

//	static boolean lineCheck(int dy, int dx, int y, int x) {
//		int ny = y;
//		int nx = x;
//		while(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]) {
//			ny+=dy;
//			nx+=dx;
//		}
//		
//		//-dy dx를 해주어 마지막으로 성공한 위치를 확인합니다.
//		ny -= dy;
//		nx -= dx;
//	}


	static void dfs(int y, int x, int cnt, int len) {
		for (int i = 0; i < 4; i++) {
//			if(lineCheck(dy[i], dx[i], y, x)) {
//				
//			}
		}

	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sw_input_1767.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cnt = Integer.MAX_VALUE;
			len = Integer.MAX_VALUE;

			arr = new ArrayList<>();
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int now = Integer.parseInt(st.nextToken());
					if (now == 1)
						visited[i][j] = true;

					arr.add(new int[] { i, j });
				}
			}

			for (int i = 0; i < arr.size(); i++) {
				dfs(arr.get(i)[0], arr.get(i)[1], 0, 0);
			}

		}
	}

}
