package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_01085_B3_직사각형에서탈출 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int result = 1001;
	
		result = Math.min(result, x-0);
		result = Math.min(result, w-x);
		result = Math.min(result, y-0);
		result = Math.min(result, h-y);
		
		System.out.println(result);
		sc.close();
	}
}
