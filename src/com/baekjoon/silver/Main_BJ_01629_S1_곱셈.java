package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_01629_S1_곱셈 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		long result = (long) Math.pow(a, b) %c;
		System.out.println(result);
		sc.close();
	}
}
