package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14626_B1_ISBN {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] nums = str.toCharArray();

		int sum = 0;
		int idx = 0;
		for(int i=0; i<12; i++){
			if('0'<=nums[i] && nums[i]<='9'){
				if(i%2==0){
					sum += nums[i]-'0';
				} else {
					sum += (nums[i]-'0')*3;
				}
			} else {
				idx = i;
			}
		}

		int target = nums[12]-'0';
		int result = -1;
		for(int i=0; i<10; i++){
			if(result>=0) break;
			int now = sum;
			if(idx%2==0){
				now += i;
			} else {
				now += 3*i;
			}
			if(now%10==0){
				if(target==0) result = i;
			} else {
				if(10 - (now%10) == target) result = i;
			}
		}

		System.out.println(result);
	}
}
