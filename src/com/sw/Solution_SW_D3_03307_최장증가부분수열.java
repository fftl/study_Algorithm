package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D3_03307_최장증가부분수열 {

	static int[] arr, dp;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_3307.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int max = 0;
			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			dp = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[j]<arr[i]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
						max = Math.max(max, dp[i]);
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
		
	}

}
