package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15656_S3_N과M7 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		sb = new StringBuilder();

		dfs(0, "");

		System.out.println(sb.toString().trim());
	}

	static void dfs(int cnt, String now){
		if(cnt == M){
			sb.append(now.trim()+"\n");
		} else {
			for (int i = 0; i < N; i++) {
				String nxt = now+" "+arr[i];
				dfs(cnt+1, nxt);
			}
		}
	}
}
