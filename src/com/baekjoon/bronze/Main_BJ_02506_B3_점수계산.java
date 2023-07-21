package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02506_B3_점수계산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int result = 0;
		int val = 1;
		for (int i = 0; i < n; i++) {
			if(st.nextToken().equals("1")) {
				result += val;
				val++;
			} else {
				val = 1;
			}
		}
		
		System.out.println(result);
	}
}
