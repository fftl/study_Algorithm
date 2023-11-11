package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_10039_B4_평균점수 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int n = sc.nextInt();
			sum += (n<40) ? 40:n;
		}
		
		System.out.println(sum/5);
		sc.close();
	}
}
