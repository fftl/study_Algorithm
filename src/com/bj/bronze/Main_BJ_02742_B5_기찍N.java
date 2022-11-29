package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_02742_B5_기찍N {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = n; i>= 1; i--) {
			sb.append(i+"\n");
		}
		
		System.out.println(sb.toString().trim());
		sc.close();
	}
}
