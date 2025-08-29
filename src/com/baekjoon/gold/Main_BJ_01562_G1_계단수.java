package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_01562_G1_계단수 {
	static final int MOD = 1_000_000_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[][][] dp = new long[n+1][10][1<<10];
		for(int i=1; i<=9; i++){
			dp[1][i][1 << i] = 1;
		}

		for(int t=2; t<=n; t++){
			for(int k=0; k<=9; k++){
				for(int visited=0; visited < (1<<10); visited++){
					int nextVisited = visited | (1 << k);

					if(k==0) dp[t][k][nextVisited] += dp[t-1][k+1][visited] %MOD;
					else if(k==9) dp[t][k][nextVisited] += dp[t-1][k-1][visited] %MOD;
					else dp[t][k][nextVisited] += dp[t-1][k+1][visited] %MOD + dp[t-1][k-1][visited] %MOD;

					dp[t][k][nextVisited] %= MOD;
				}
			}
		}

		long sum = 0;
		for(int i=0; i<=9; i++){
			sum += dp[n][i][(1<<10) - 1] % MOD;
			sum %= MOD;
		}

		System.out.println(sum);

	}
}

