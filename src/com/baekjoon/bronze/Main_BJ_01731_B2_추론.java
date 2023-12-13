package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01731_B2_추론 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		boolean check1 = true;
		int cha = arr[1]-arr[0];
		for (int i = 2; i < n; i++) {
			int nowCha = arr[i]-arr[i-1];
			int nowBe = arr[i]/arr[i-1];
			if(nowCha != cha){
				check1 = false;
				break;
			}
		}

		if(check1){
			System.out.println(arr[n-1]+cha);
			return;
		}

		System.out.println(arr[n-1]*(arr[1]/arr[0]));
	}
}
