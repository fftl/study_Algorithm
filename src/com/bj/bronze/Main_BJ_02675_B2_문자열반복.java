package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_02675_B2_문자열반복 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for (int j = 0; j < str.length(); j++) {
				for (int j2 = 0; j2 < n; j2++) {
					sb.append(str.charAt(j));
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
