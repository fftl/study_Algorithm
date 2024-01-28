package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02524_B3_별찍기13 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			String now = "";
			for (int j = 0; j < i; j++) {
				now += "*";
			}
			sb.append(now+"\n");
		}

		for (int i = n-1; i >= 1; i--) {
			String now = "";
			for (int j = 0; j < i; j++) {
				now += "*";
			}
			sb.append(now+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
