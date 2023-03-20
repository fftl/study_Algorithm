package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_13458_B2_시험감독 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		long main = Long.parseLong(st.nextToken());
		long sub = Long.parseLong(st.nextToken());
		
		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			result++;
			long now = arr[i]-main;
			
			if(now>0) {
				result += now/sub;
				if(now%sub > 0) result++;
			}
		}
		
		System.out.println(result);
		
	}
}
