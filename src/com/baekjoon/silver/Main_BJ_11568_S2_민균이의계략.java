package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11568_S2_민균이의계략 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			if(dp[i] == 0) dp[i] = 1;
			int before = arr[i];
			for (int j = i+1; j < n; j++) {
			}
		}
		
		
	}
}
