package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_04504_B3_배수찾기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while(true){
			int now = Integer.parseInt(br.readLine());
			if(now == 0) break;

			if(now%n==0){
				sb.append(now + " is a multiple of "+n+".\n");
			}  else {
				sb.append(now + " is NOT a multiple of "+n+".\n");
			}
		}

		System.out.println(sb.toString().trim());
	}
}
