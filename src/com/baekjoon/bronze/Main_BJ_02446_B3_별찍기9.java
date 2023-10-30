package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02446_B3_별찍기9 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		int space = 0;
		int star = 2*n-1;

		for (int i = 0; i < n; i++) {
			for(int j=0; j<space; j++){
				sb.append(" ");
			}

			for (int j = 0; j < star; j++) {
				sb.append("*");
			}
			space++;
			star -= 2;
			sb.append("\n");
		}

		space--;
		star += 2;

		for (int i = 0; i < n-1; i++) {
			star += 2;
			space--;
			for(int j=0; j<space; j++){
				sb.append(" ");
			}

			for (int j = 0; j < star; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString().trim());
	}
}
