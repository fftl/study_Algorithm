package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10989_B1_수정렬하기3 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10001];
		
		for (int i = 0; i < t; i++) {
			int now = Integer.parseInt(br.readLine());
			arr[now]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < 10001; i++) {
			if(arr[i] == 0) continue;
			for (int j = 0; j < arr[i]; j++) {
				sb.append(i+"\n");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
