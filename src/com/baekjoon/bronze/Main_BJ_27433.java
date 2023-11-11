package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_27433_B5_팩토리얼2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long res = 1;
		if(n==0) {
			System.out.println(1);
		 	return;
		} else {
			for (int i = 1; i <= n; i++) {
				res *= i;
			}
		}

		System.out.println(res);
	}
}
