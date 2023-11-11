package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02711_B2_오타맨고창영 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			for (int j = 0; j < str.length(); j++) {
				if(j != idx-1)sb.append(str.charAt(j));
			}
			sb.append("\n");
		}

		System.out.println(sb.toString().trim());
	}
}
