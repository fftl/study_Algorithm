package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11549_B4_IdentifyingTea {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;

		for (int i = 0; i < 5; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(now==n)cnt++;
		}

		System.out.println(cnt);
	}
}
