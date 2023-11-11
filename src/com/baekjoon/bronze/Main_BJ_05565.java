package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_05565_B3_영수증 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int first = 0;
		for (int i = 0; i < 10; i++) {
			if(i==0) {
				first = Integer.parseInt(br.readLine());
			} else {
				first -= Integer.parseInt(br.readLine());
			}
		}
		
		System.out.println(first);
		
	}
}
