package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10870_B2_피보나치수5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[20+1];
		
		nums[0] = 0;
		nums[1] = 1;
		
		for (int i = 2; i < nums.length; i++) {
			nums[i] = nums[i-1]+nums[i-2];
		}
		
		System.out.println(nums[n]);
	}
}
