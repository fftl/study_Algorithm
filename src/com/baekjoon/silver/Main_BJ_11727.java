package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_11727_S3_2xn타일링2 {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1]+dp[i-2]*2)%10007;
		}
		
		System.out.println(dp[n]);
		sc.close();
	}
}