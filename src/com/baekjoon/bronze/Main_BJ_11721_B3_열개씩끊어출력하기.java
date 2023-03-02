package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_11721_B3_열개씩끊어출력하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		String now = "";
		for (int i = 0; i < str.length(); i++) {
			now += str.charAt(i);
			if(now.length() == 10) {
				sb.append(now+"\n");
				now = new String();
			}
		}
		
		if(now != "") {
			sb.append(now+"\n");	
		}
		System.out.println(sb.toString().trim());
	}
}
