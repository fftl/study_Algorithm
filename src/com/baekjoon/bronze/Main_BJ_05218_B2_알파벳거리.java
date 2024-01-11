package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_05218_B2_알파벳거리 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append("Distances:");
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			for (int j = 0; j < a.length(); j++) {
				char ac = a.charAt(j);
				char bc = b.charAt(j);

				int ans = bc-ac < 0 ? bc-ac+26 : bc-ac;
				sb.append(" "+ans);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString().trim());
	}
}
