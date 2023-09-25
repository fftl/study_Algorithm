package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_05988_B3_홀수일까짝수일까 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String now = br.readLine();
			int num = now.charAt(now.length()-1)-'0';
			if(num%2==0) sb.append("even\n");
			else sb.append("odd\n");
		}
		System.out.println(sb.toString().trim());
	}
}
