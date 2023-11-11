package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_09713_B3_SumOfOddSequence {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[100+1];
		nums[1] = 1;
		for (int i = 3; i <= 100; i+=2) {
			nums[i] = i+nums[i-2];
		}

		for (int i = 0; i < n; i++) {
			int idx = Integer.parseInt(br.readLine());
			System.out.println(nums[idx]);
		}
	}
}
