package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02167_S5_2차원배열의합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < cnt; i++) {
			int now = 0;
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken())-1;
			int sx = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			int ex = Integer.parseInt(st.nextToken())-1;

			for (int j = sy; j <= ey; j++) {
				for (int k = sx; k <= ex; k++) {
					now += arr[j][k];
				}
			}

			System.out.println(now);
		}
	}
}
