package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//아무래도 DP 문제처럼 보인다.
//
public class Main_BJ_07579_G3_앱 {
	static int N, M;
	static int[] run, cost;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int ans = Integer.MAX_VALUE;
		
		run = new int[N];
		cost = new int[N];
		int[][] dp = new int[N][100001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			run[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int nCost = cost[i];
			int nRun = run[i];
			
			for (int j = 0; j <= 10000; j++) {
				if(i==0) {
					if( j >= nCost ) dp[i][j] = nRun;
				} else {
					if( j >= nCost ) dp[i][j] = Math.max(dp[i-1][j-nCost] + nRun, dp[i-1][j]);
					else dp[i][j] = dp[i-1][j];
				}
				
				if(dp[i][j] >= M) ans = Math.min(ans, j); 
			}
		}
		
		System.out.println(ans);
	}
}
