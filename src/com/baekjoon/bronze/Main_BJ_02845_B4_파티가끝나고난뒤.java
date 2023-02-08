package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02845_B4_파티가끝나고난뒤 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int num = a*b;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(sc.nextInt()-num+" ");
		}
		
		System.out.println(sb.toString().trim());
		sc.close();
	}
}

