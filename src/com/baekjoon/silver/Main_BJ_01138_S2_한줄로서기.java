package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01138_S2_한줄로서기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[n];
		for (int i = 1; i <= n; i++) {
			int now = arr[i];
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if(cnt==now && result[j] == 0){
					result[j] = i;
					break;
				}

				if(result[j] == 0){
					cnt++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i]+" ");
		}

		System.out.println(sb.toString().trim());
	}
}
