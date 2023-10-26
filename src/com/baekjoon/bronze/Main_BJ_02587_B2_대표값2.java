package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_02587_B2_대표값2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] nums = new int[5];
		for (int i = 0; i < 5; i++) {
			int now = Integer.parseInt(br.readLine());
			nums[i] = now;
			sum += now;
		}

		Arrays.sort(nums);
		System.out.println(sum/5);
		System.out.println(nums[2]);
	}
}
