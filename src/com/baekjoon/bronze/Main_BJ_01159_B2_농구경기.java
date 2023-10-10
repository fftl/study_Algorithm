package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01159_B2_농구경기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if(n<5){
			System.out.println("PREDAJA");
		} else {
			int[] check = new int[26];
			for (int i = 0; i < n; i++) {
				check[br.readLine().charAt(0)-'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				if(check[i]>=5) sb.append((char)('a'+i));
			}
			if(sb.length()==0) System.out.println("PREDAJA");
			else System.out.println(sb.toString().trim());
		}
	}
}
