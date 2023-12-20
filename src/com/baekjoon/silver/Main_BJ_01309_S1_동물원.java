package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01309_S1_동물원 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 9901;
		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n+1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%mod;
			dp[i][1] = (dp[i-1][0]+dp[i-1][2])%mod;
			dp[i][2] = (dp[i-1][0]+dp[i-1][1])%mod;
		}

		long ans = (dp[n][0]+dp[n][1]+dp[n][2])%mod;
		System.out.println(ans);
	}
}
