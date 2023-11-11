package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01392_B2_노래악보 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] data = new int[N+1];
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			int now = Integer.parseInt(br.readLine());
			data[i] = now;
			sum += now;
		}

		int[] log = new int[sum];
		int num = 1;
		int idx = 0;
		for (int size : data) {
			if(size == 0) continue;
			for (int i = 0; i < size; i++) {
				log[idx++] = num;
			}
			num++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			sb.append(log[Integer.parseInt(br.readLine())]+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}

