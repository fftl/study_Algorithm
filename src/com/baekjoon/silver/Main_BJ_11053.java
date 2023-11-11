package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11053_S2_가장긴증가하는부분순열 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int result = 1;
		
		int[] arr = new int[t];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[t];
		for (int i = 0; i < t; i++) {
			dp[i] = 1;
			boolean yes = false;
			int yesMax = 0;
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i] && yesMax<dp[j]) {
					yesMax = dp[j];
					yes = true;
				}
			}
			
			if(yes) {
				dp[i] = yesMax+1;
				result = Math.max(result, dp[i]);
			};
		}
		
		System.out.println(result);
	}
}
