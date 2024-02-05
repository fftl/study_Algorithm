package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_28224_B4_FinalPrice {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			result += now;
		}

		System.out.println(result);
	}
}
