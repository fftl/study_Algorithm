package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01371_B2_가장많은글자 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] alp = new int[26];
		String line = br.readLine();
		while(line != null){
			sb.append(line);
			line = br.readLine();
		}

		String str = sb.toString();
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if(now == ' ') continue;

			alp[now-97]++;
		}

		int findMax = 0;
		for (int i = 0; i < 26; i++) {
			findMax = Math.max(findMax, alp[i]);
		}

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if(alp[i] == findMax){
				char now = (char)(97+i);
				res.append(now);
			}
		}

		System.out.println(res.toString().trim());
	}
}
