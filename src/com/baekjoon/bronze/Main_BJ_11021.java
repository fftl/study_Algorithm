package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_11021_B5_AplusB7 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("Case #"+(i+1)+": "+(a+b));
		}
		sc.close();
	}
}
