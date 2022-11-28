package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_02753_B5_윤년 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n%4 == 0 && n%100 != 0) {
			System.out.println(1);
		} else if(n%400 == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
		sc.close();
	}
}
