package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_10867_S5_중복빼고정렬하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		int before = arr[0];
		for (int i = 0; i < n; i++) {
			if(i==0) sb.append(arr[i] + " ");
			else {
				if(before == arr[i]) {
					continue;
				} else {
					sb.append(arr[i] + " ");
					before = arr[i];
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
