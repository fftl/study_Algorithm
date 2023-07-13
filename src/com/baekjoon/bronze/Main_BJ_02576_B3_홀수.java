package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02576_B3_홀수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = 100;
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now%2!=0) {
				min = Math.min(min, now);
				sum += now;
			}
		}
		
		if(sum==0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
