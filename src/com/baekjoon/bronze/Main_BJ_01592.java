package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01592_B2_영식이와친구들 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int max = 0;
		int[] arr = new int[N+1];
		int idx = 1;
		arr[idx]++;
		max = Math.max(arr[idx], max);

		while(max<M) {
			idx = (idx+L)%N;
			arr[idx]++;
			max = Math.max(arr[idx], max);
			cnt++;
		}

		System.out.println(cnt);

	}
}
