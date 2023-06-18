package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02442_B3_별찍기5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = n-1;
		int cnt = 1;
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < num; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < cnt; j++) {
				System.out.print("*");
			}
			
			System.out.println();
			
			num--;
			cnt+=2;
		}
	}
}
