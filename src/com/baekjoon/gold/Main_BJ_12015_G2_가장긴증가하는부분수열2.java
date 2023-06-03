package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_12015_G2_가장긴증가하는부분수열2 {
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
	}
}
