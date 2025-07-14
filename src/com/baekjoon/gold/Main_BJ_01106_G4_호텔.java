package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_01106_G4_호텔 {

	static int C, N;
	static int[] dp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		dp = new int[C+101];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int man = Integer.parseInt(st.nextToken());

			for(int j=man; j<C+101; j++){
				dp[j]=Math.min(dp[j], cost+dp[j-man]);
			}
		}

		int result = Integer.MAX_VALUE;
		for(int i=C; i<C+101; i++){
			result = Math.min(result, dp[i]);
		}

		System.out.println(result);
	}
}
