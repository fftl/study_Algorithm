package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02445_B3_별찍기8 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(j<=i){
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}

			String back = new String();
			for (int j = 1; j <= n; j++) {
				if(j<=i){
					back += "*";
				} else {
					back = " "+back;
				}
			}
			sb.append(back+"\n");
		}

		for (int i = n-1; i >= 1; i--) {
			for (int j = 1; j <= n; j++) {
				if(j<=i){
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}

			String back = new String();
			for (int j = 1; j <= n; j++) {
				if(j<=i){
					back += "*";
				} else {
					back = " "+back;
				}
			}
			sb.append(back+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
