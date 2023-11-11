package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02438_B5_별찍기1 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			String now = "";
			for (int j = 0; j < i; j++) {
				now += "*";
			}
			System.out.println(now);
		}
		sc.close();
		
	}
}
