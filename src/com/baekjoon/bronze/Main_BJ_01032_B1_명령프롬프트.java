package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01032_B1_명령프롬프트 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strs = new String[n];

		for (int i = 0; i < n; i++) {
			strs[i] = br.readLine();
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < strs[0].length(); i++) {
			boolean check = true;
			for (int j = 1; j < n; j++) {
				if(strs[j-1].charAt(i) != strs[j].charAt(i)) {
					check = false;
					break;
				}
			}
			if(check){
				sb.append(strs[0].charAt(i));
			} else {
				sb.append("?");
			}
		}

		System.out.println(sb.toString());
	}
}
