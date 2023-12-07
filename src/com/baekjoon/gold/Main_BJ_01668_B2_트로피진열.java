package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01668_B2_트로피진열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int upCnt = 1;
		int upStart = arr[0];
		for (int i = 1; i < n; i++) {
			if(upStart<arr[i]){
				upStart = arr[i];
				upCnt++;
			}
		}

		int downCnt = 1;
		int downStart = arr[n-1];
		for (int i = n-2; i >= 0; i--) {
			if(downStart<arr[i]){
				downStart = arr[i];
				downCnt++;
			}
		}

		System.out.println(upCnt);
		System.out.println(downCnt);
	}
}
