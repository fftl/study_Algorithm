package com.baekjoon.silver;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_BJ_02407_S3_조합 {
	
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger sum = BigInteger.ONE;
		BigInteger div = BigInteger.ONE;
		
		for (int i = 0; i < m; i++) {
			sum = sum.multiply(new BigInteger(String.valueOf(n-i)));
			div = div.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(sum.divide(div));
		
		sc.close();
	}
}
