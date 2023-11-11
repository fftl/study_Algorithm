package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_09465_S1_스티커 {
	static int[][] dp;
	static int[][] score;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			dp = new int[2][n+1];
			score = new int[2][n+1];
			
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 1; j2 <= n; j2++) {
					score[j][j2] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = score[0][1];
			dp[1][1] = score[1][1];
			
			for (int j = 2; j <= n; j++) {
				dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + score[0][j];
				dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + score[1][j];
			}
			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}
