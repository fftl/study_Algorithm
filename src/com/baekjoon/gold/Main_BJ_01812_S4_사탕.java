package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01812_S4_사탕 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		sum/=2;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n; i++) {
			sb.append((sum-arr[i])+"\n");
		}

		sb.append(sum-arr[0]);
		System.out.println(sb);
	}
}
