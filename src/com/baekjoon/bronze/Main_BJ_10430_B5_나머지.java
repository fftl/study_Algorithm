package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_10430_B5_나머지 {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println(((A%C)+(B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C)*(B%C))%C);
		
		sc.close();
	}
}
