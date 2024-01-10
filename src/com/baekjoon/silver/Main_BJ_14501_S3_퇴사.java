package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_14501_S3_퇴사 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		ArrayList<int[]> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			arr.add(new int[]{d, p});
		}

		int[] dp = new int[n+1];

		for (int i = 0; i < n; i++) {
			if(i+arr.get(i)[0] <= n){
				dp[i+arr.get(i)[0]] = Math.max(dp[i+arr.get(i)[0]], dp[i]+arr.get(i)[1]);
			}

			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}

		System.out.println(dp[n]);
	}
}
