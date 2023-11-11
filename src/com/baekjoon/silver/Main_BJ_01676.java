package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_01676_S5_팩토리얼0의개수 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int count = 0;
		while(n>=5) {
			count += n/5;
			n/=5;
		}
		
		System.out.println(count);
		sc.close();
	}
}
