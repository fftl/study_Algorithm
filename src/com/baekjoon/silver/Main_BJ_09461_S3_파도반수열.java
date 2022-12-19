package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_09461_S3_파도반수열 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		long[] dp = new long[101];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
