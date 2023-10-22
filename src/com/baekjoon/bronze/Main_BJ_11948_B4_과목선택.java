package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11948_B4_과목선택 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[4];
		int[] arr2 = new int[2];
		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < 2; i++) {
			arr2[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		Arrays.sort(arr2);

		System.out.println(arr[3]+arr[2]+arr[1]+arr2[1]);
	}
}
