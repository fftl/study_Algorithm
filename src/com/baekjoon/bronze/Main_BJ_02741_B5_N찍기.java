package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02741_B5_N찍기 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(i+"\n");
		}
		
		System.out.println(sb.toString().trim());
		sc.close();
	}
}
