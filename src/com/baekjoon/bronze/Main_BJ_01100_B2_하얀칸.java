package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01100_B2_하얀칸 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int res = 0;
		for (int i = 0; i < 8; i++) {
			String now = br.readLine();
			if(i%2 == 0) {
				for (int j = 0; j < 8; j++) {
					if(j%2==0 && now.charAt(j)=='F') {
						res++;
					}
				}
			} else {
				for (int j = 0; j < 8; j++) {
					if(j%2!=0 && now.charAt(j)=='F') {
						res++;
					}
				}
			}
		}
		
		System.out.println(res);
		
		
	}
}
