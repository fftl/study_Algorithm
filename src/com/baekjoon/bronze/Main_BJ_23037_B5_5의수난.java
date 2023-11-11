package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_23037_B5_5의수난 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int result = 0;

		for (int i = 0; i < 5; i++) {
			int now = n.charAt(i)-'0';
			int res = now;
			for (int j = 0; j < 4; j++) {
				res *= now;
			}
			result += res;
		}

		System.out.println(result);
	}
}
