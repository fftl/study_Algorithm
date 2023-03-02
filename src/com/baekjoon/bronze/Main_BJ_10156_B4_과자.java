package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_10156_B4_과자 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int sum = a*b;
		if(sum-c>0) System.out.println(sum-c);
		else System.out.println(0);
		sc.close();
	}
}
