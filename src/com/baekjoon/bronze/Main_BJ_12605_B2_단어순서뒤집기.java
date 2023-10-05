package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_12605_B2_단어순서뒤집기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			String[] str = br.readLine().split(" ");
			sb.append("Case #"+i+": ");
			for (int j = str.length-1; j>=0; j--) {
				if(j==0) sb.append(str[j]+"\n");
				else {
					sb.append(str[j]+" ");
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
