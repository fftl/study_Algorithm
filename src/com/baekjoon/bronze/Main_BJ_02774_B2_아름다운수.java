package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_BJ_02774_B2_아름다운수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			String str = br.readLine();
			Set<Character> check = new HashSet<>();

			for (int j = 0; j < str.length(); j++) {
				if(check.size()>=10) break;
				check.add(str.charAt(j));
			}

			sb.append(check.size()+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
