package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_12755_S4_수면장애 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int num = 1;
		while(sb.length()<n) {
			sb.append(num);
			num++;
		}
		
		System.out.println(sb.charAt(n-1));
	}
}
