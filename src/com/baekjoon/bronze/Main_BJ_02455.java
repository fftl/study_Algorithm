package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02455_B3_지능형기차 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int now = 0;
		int max = 0;
		for (int i = 0; i < 4; i++) {
			max = Math.max(max, now);

			st = new StringTokenizer(br.readLine());
			int output = Integer.parseInt(st.nextToken());
			int input = Integer.parseInt(st.nextToken());

			now -= output;
			now += input;
		}

		System.out.println(max);
	}
}
