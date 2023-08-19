package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02010_B3_플러그 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		if(n == 1) {
			System.out.println(Integer.parseInt(br.readLine()));
			return;
		}

		int sum =  0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(br.readLine());
		}

		System.out.println(sum-n+1);
	}
}
