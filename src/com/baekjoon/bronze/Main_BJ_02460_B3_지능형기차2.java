package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02460_B3_지능형기차2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int res = 0;
		int now = 0;
		for (int i = 0; i < 10; i++) {
				st = new StringTokenizer(br.readLine());
				int out = Integer.parseInt(st.nextToken());
				int in = Integer.parseInt(st.nextToken());

				now = now-out+in;
				res = Math.max(now, res);
		}

		System.out.println(res);

	}
}
