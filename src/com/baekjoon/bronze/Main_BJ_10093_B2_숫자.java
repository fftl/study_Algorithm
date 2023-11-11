package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10093_B2_숫자 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (long i = Math.min(a, b)+1; i < Math.max(a,b); i++) {
			sb.append(i+" ");
			cnt++;
		}

		System.out.println(cnt);
		System.out.println(sb.toString().trim());
	}
}
