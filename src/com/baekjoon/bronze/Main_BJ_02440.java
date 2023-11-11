package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02440_B4_별찍기3 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for (int i = n; i > 0; i--) {
			String star = "";
			for (int j = 0; j < i; j++) {
				star += "*";
			}
			sb.append(star+"\n");
		}
		
		System.out.println(sb.toString().trim());
		sc.close();
	}
}
