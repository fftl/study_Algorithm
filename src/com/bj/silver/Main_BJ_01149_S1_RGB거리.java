package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01149_S1_RGB거리 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][3];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int nowR = Integer.parseInt(st.nextToken());
			int nowG = Integer.parseInt(st.nextToken());
			int nowB = Integer.parseInt(st.nextToken());
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + nowR;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + nowG;
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + nowB;
			
		}
		
		int result = dp[n][0];
		if(result>dp[n][1]) result = dp[n][1];
		if(result>dp[n][2]) result = dp[n][2];
		System.out.println(result);
	}
}
