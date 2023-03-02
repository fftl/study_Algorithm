package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10808_B4_알파벳개수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] test = new int[26];
		for (int i = 0; i < s.length(); i++) {
			test[s.charAt(i)-97]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append(test[i]+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
