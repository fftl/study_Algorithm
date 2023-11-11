package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_10811_B2_바구니뒤집기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for(int i=0; i<=N; i++) arr[i] = i;
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			for (int j = s; j <= e; j++) {
				list.add(arr[j]);
			}
			
			int idx = 0;
			for (int j = e; j >= s; j--) {
				arr[j] = list.get(idx);
				idx++;
			}
			list.clear();
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
