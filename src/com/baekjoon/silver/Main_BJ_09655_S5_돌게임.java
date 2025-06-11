package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_09655_S5_돌게임 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if(n>5){
			int[] dp = new int[n+1];
			dp[1] = 0;
			dp[2] = 1;
			dp[3] = 0;
			dp[4] = 1;
			dp[5] = 0;
			for(int i=6; i<=n; i++){
				dp[i] = dp[i-4];
			}

			if(dp[n] == 0) System.out.println("SK");
			else System.out.println("CY");
		} else {
			switch (n){
				case 1:{
					System.out.println("SK");
					break;
				}
				case 2:{
					System.out.println("CY");
					break;
				}
				case 3:{
					System.out.println("SK");
					break;
				}
				case 4:{
					System.out.println("CY");
					break;
				}
				case 5:{
					System.out.println("SK");
					break;
				}
			}
		}

		/*
		1 sk
		2 cy
		3 sk
		4 cy
		5 sk
		6 cy
		7
		 */
	}
}
