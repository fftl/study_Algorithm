package com.baekjoon.silver;

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
		
		int[][] board = new int[n][n];
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = board[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==0 && j==0) continue;
				
				if(i==0) {
					dp[i][j] = dp[i][j-1]+board[i][j];
				} else if(j==0) {
					dp[i][j] = dp[i-1][j]+board[i][j];
				} else {
					dp[i][j] = dp[i-1][j]+dp[i][j-1]+board[i][j] - dp[i-1][j-1];
				}
			}
		}
		
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			int ex = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			
			int end = dp[ex][ey];
			if(sx==ex && sy==ey) {
				System.out.println(board[sx][sy]);
				continue;
			}
			
			if(sx == 0 && sy == 0) {
				System.out.println(end);
			} else if(sx == 0){
				System.out.println(end-dp[ex][sy-1]);
			} else if(sy == 0) {
				System.out.println(end-dp[sx-1][ey]);
			} else {
				System.out.println(end-dp[sx-1][ey]-dp[ex][sy-1]+dp[sx-1][sy-1]);
			}
			
		}
	}
}
