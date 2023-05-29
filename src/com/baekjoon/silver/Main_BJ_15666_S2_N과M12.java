package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15666_S2_N과M12 {

	static int N, M; //N개 M개의 자연수
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

		int[] now = new int[M];
		dfs(0, 0, now);
	}

	static void dfs(int cnt, int start, int[] now){
		if(cnt == M){
			sb = new StringBuilder();
			for (int j = 0; j < M; j++) {
				sb.append(now[j]+" ");
			}
			System.out.println(sb.toString().trim());
			return;
		}

		int num = 0;
		for(int i=start; i<N; i++){
			if(num==arr[i]) continue;
			now[cnt] = arr[i];
			dfs(cnt+1, i, now);
			num = arr[i];
		}
	}
}
