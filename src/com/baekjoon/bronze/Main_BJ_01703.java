package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01703_B3_생장점 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] nums = br.readLine().split(" ");
			if(nums.length == 1) {
				break;
			} else {
				int idx = 0;
				int n = Integer.parseInt(nums[idx]);
				
				idx++;
				int res = -1;
				for (int i = 0; i < n; i++) {
					int a = Integer.parseInt(nums[idx]);
					idx++;
					int b = Integer.parseInt(nums[idx]);
					idx++;
					
					if(res == -1) {
						res = a;
						res -= b;
					} else {
						res = res*a;
						res -= b;
					}				
				}
				System.out.println(res);
			}
			
		}
	}
}
