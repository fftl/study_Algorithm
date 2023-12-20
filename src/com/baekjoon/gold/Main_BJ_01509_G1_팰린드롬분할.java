package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01509_G1_팰린드롬분할 {
	static int[] dp;
	static boolean[][] pal;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();

		dp = new int[len+1];
		pal = new boolean[len+1][len+1];

		for (int i = 1; i <= len; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		palCheck(str, len);

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= i; j++) {
				if(pal[j][i]) dp[i] = Math.min(dp[i], dp[j-1]+1);
			}
		}

		System.out.println(dp[len]);
	}

	static void palCheck(String str, int len){

		for(int stt = 1; stt <= len; stt++){
			for (int end = stt; end <= len; end++) {
				boolean flag = true;
				int s = stt-1;
				int e = end-1;
				while(s <= e){
					if(str.charAt(s++) != str.charAt(e--)){
						flag = false;
						break;
					}
				}
				if(flag) pal[stt][end] = true;
			}
		}
	}
}
