package com.baekjoon.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_BJ_11444_G2_피보나치수6 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong();
		ArrayList<Long> fibo = new ArrayList<>();
		fibo.add(0L);
		fibo.add(1L);
		
		for (int i = 2; i <= l; i++) {
			fibo.add((fibo.get(i-2)+fibo.get(i-1))%1000000007);
		}
		
		System.out.println(fibo.get(fibo.size()-1));
		
		sc.close();
	}
}
