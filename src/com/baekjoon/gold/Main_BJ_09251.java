package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_09251_G5_LCS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		int size1 = a.length();
		int size2 = b.length();
		int[][] dp = new int[size1 + 1][size2 + 1];

		for (int i = 1; i <= size1; i++) {
			for (int j = 1; j <= size2; j++) {
				if (a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		System.out.println(dp[size1][size2]);
	}
}
