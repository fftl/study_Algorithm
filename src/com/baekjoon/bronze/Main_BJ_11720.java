package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_11720_B4_숫자의합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		String[] nums = str.split("");
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += Integer.parseInt(nums[i]);
		}
		
		System.out.println(result);
	}
}
