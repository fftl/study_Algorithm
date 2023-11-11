package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01964_B2_오각형오각형 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] stage = new int[n+1];
		stage[1] = 5;

		for (int i = 2; i <= n; i++) {
			stage[i] = (stage[i-1] + (3*(i+1))-2)%45678;
		}

		System.out.println(stage[n]);
	}
}
