package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_03190_G4_뱀 {
	static int N, K, L, direct, s; //direct - 방향, s - 시간
	static boolean[][] apple;
	static boolean[][] board;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		apple = new boolean[N][N];
		board = new boolean[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			apple[y][x] = true;
		}

		L = Integer.parseInt(br.readLine());
		board[0][0] = true;
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
		}
	}


}
