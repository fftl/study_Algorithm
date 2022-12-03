package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_16637_G4_괄호추가하기 {
	static int max;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		max = str.charAt(0)-'0';
		
		
		for (int i = 0; i < N; i++) {
			int c = str.charAt(i);
			if('0' <= c &&  c <= '9') {
				
			} else {
				
			}
		}
		
	}
}
