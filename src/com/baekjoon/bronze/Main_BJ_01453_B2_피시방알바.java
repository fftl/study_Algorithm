package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01453_B2_피시방알바 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[101];

		st = new StringTokenizer(br.readLine());

		int res = 0;
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(check[now]) res++;
			else check[now] = true;
		}

		System.out.println(res);
	}
}
