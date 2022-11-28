package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11660_S1_구간합구하기5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n + 1][n + 1];
		int[][] basic = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				basic[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1] + basic[i][j];
			}
		}
		
		System.out.println(Arrays.deepToString(arr));
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken());
			int sx = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());

			int sum = arr[ey][ex];

			if (sx == 1) {
				sum -= arr[sy - 1][n];
			} else {
				sum -= arr[sy][sx - 1];
			}

			for (int j = sy; j <= ey; j++) {
				for (int k = 0; k < n; k++) {
					if (j == sy) {
						continue;
					} else if (j == ey) {
						if (k < sx) {
							sum -= basic[j][k];
						}
					} else {
						if (k < sx || k > ex) {
							sum -= basic[j][k];
						}
					}
				}
			}

			sb.append(sum + "\n");
		}

		System.out.println(sb.toString().trim());
	}
}
