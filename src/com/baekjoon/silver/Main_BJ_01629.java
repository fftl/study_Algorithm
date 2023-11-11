package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_01629_S1_곱셈 {
	static long c;
	
	static long div(long a, long zisu) {
		if(zisu == 1) return a%c;
		
		long temp = div(a, zisu/2);
		
		if(zisu % 2 == 1) {
			return (temp * temp % c) * a % c;
		}
		
		return temp * temp % c;
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		c = sc.nextLong();
		
		long result = div(a, b);
		System.out.println(result);
		sc.close();
	}
}
