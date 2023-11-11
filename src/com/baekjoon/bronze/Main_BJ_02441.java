package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02441_B3_별찍기4 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<n; i++) {
			String now = new String();
			for (int j = 1; j <=n; j++) {
				if(j<=i) now += " ";
				else now += "*";
			}
			sb.append(now+"\n");
		}
		System.out.println(sb.toString().trim());
		
		sc.close();
	}
}
