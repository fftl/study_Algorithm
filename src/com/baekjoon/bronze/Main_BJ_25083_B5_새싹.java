package com.baekjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_BJ_25083_B5_새싹 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		BigInteger A = new BigInteger(a);
		BigInteger B = new BigInteger(b);

		System.out.println(A.add(B));
	}
}
