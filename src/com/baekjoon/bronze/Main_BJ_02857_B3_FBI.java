package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02857_B3_FBI {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length()-2; j++) {
				if(str.substring(j, j+3).equals("FBI")) {
					sb.append(i+" ");
					cnt++;
					break;
				}
			}
		}
		
		if(cnt==0)System.out.println("HE GOT AWAY!");
		else System.out.println(sb.toString().trim());
	}
}
