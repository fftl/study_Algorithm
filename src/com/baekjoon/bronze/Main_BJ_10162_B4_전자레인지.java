package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10162_B4_전자레인지 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		for (int i = 0; i < 5; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(n==num) result++;
		}
		
		System.out.println(result);
	}
}
