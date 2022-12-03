package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02577_B2_숫자의개수 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int sum = a*b*c;
		int[] result = new int[10];
		
		String str = Integer.toString(sum);
		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i)-'0';
			result[now]++;
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		sc.close();
	}
}
