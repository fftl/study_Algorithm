package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_14003_P5_가장긴증가하는부분수열5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] lis = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		lis[0] = arr[0];
		int lisMax = 0;

		for (int i = 1; i < n; i++) {
			int now = arr[i];
			if(now>lis[lisMax]){
				lis[lisMax+1] = now;
				lisMax++;
			} else {
				int s = 0;
				int e = lisMax;
				int mid = (s+e)/2;
				while(s<e) {
					mid = (s + e) / 2;
					if (lis[mid] < now) {
						s = mid + 1;
					} else {
						e = mid;
					}
				}

				lis[s] = now;
			}
		}
		System.out.println(lisMax+1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < lisMax+1; i++) {
			sb.append(lis[i]+" ");
		}
		System.out.println(sb.toString().trim());
	}
}
