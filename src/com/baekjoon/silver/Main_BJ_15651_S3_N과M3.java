package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15651_S3_N과M3 {
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			run(1, Integer.toString(i));
		}

		System.out.println(sb.toString().trim());
	}

	static void run(int cnt, String text){
		if(cnt == M){
			sb.append(text+"\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			run(cnt+1, text+" "+i);
		}
	}
}
