package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1
*/

public class Main_BJ_17406_G4_배열돌리기4 {
	static int N, M, R, min;
	static int[] result;
	static int[][] board, copy;
	static boolean[] visited;
	static ArrayList<int[]> arr;

	//최소값 찾아주기!
	static void findMin() {
		for (int i = 0; i < copy.length; i++) {
			int now = 0;
			for (int j = 0; j < copy[0].length; j++) {
				now += copy[i][j];
			}
			min = Math.min(now, min);
		}
	}

	// 순열 찾기!
	static void perm(int cnt) {
		if (cnt == R) {
			//copy 배열을 만등러서 copy를 돌려줍니다!
			//원본은 살아있어야 하니까!
			copy = new int[N][M];
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					copy[i][j] = board[i][j];
				}
			}

			for (int i = 0; i < R; i++) {
				int[] g = arr.get(result[i]);
				turn(g[0], g[1], g[2]);
			}
			findMin();
			return;
		}

		for (int i = 0; i < R; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			result[cnt] = i;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	// 돌려주기!
	static void turn(int a, int b, int D) {
		
		//문제에서의 인덱스는 시작인덱스가 1,1 이라서 저와 맞춰주기 위해서 -1을 해줍니다.
		int Y = a - 1;
		int X = b - 1;

		//안쪽으로 몇번 들어가야하는지 구해주기 위함입니다!
		int loop = Math.min((a + D) - (a - D), (b + D) - (b - D));

		for (int dep = 0; dep < loop / 2; dep++) {
			int y = Y - D + dep;
			int x = X - D + dep;
			int start = copy[y][x];
			
			//돌리기 ~~
			while (y + 1 <= Y + D - dep) {
				copy[y][x] = copy[y + 1][x];
				y++;
			}

			while (x + 1 <= X + D - dep) {
				copy[y][x] = copy[y][x + 1];
				x++;
			}

			while (y - 1 >= Y - D + dep) {
				copy[y][x] = copy[y - 1][x];
				y--;
			}

			while (x - 1 >= X - D + dep) {
				copy[y][x] = copy[y][x - 1];
				x--;
			}
			
			// 가장 시작부분은 start에 담아두었다가 그대로 넣어줍니다!
			copy[y][x + 1] = start;
		}
	}

	// 메인!
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int[] now = new int[3];
			for (int j = 0; j < 3; j++) {
				now[j] = Integer.parseInt(st.nextToken());
			}
			arr.add(now);
		}

		visited = new boolean[R];
		result = new int[R];
		perm(0);

		System.out.println(min);
	}

}
