package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_26561_B4_Population {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long num = Long.parseLong(st.nextToken());
			long s = Long.parseLong(st.nextToken());
			long result = num;
			result -= s / 7;
			result += s / 4;

			System.out.println(result);
		}
	}
}
