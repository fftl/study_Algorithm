package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01120_S4_문자열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
	
		int min = 50;
		
		for (int i = 0; i <= b.length()-a.length(); i++) {
			int now = 0;
			for (int j = 0; j < a.length(); j++) {
				if(b.charAt(i+j) != a.charAt(j)) now++;
			}
			min = Math.min(min, now);
		}
		
		System.out.println(min);
	}
}
