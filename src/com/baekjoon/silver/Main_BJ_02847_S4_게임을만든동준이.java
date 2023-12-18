package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_02847_S4_게임을만든동준이 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;

		int[] arr = new int[n];

		for (int i = n-1; i >= 0; i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n-1; i++) {
			if(arr[i+1]>=arr[i]){
				result += arr[i+1]-arr[i]+1;
				arr[i+1] = arr[i]-1;
			}
		}

		System.out.println(Arrays.toString(arr));
		System.out.println(result);
	}
}
