package com.baekjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_BJ_02338_B5_긴자리계산 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		sc.close();
		
	}
}
