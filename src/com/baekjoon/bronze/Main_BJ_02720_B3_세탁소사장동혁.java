package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02720_B3_세탁소사장동혁 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			int now = Integer.parseInt(br.readLine());
			
			int q = 0;
			while(now-25>=0) {
				q++;
				now -= 25;
			}
			
			int d = 0;
			while(now-10>=0) {
				d++;
				now -= 10;
			}
			
			int n = 0;
			while(now-5>=0) {
				n++;
				now -= 5;
			}
			
			int p = 0;
			while(now-1>=0) {
				p++;
				now -= 1;
			}
			
			sb.append(q+" "+d+" "+n+" "+p+"\n");
		}
		System.out.println(sb.toString().trim());
		
	}
}
