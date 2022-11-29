package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_02908_B2_상수 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		StringBuilder sb = new StringBuilder(a);
		a = sb.reverse().toString();
		
		sb = new StringBuilder(b);
		b = sb.reverse().toString();
		
		if(Integer.parseInt(a)> Integer.parseInt(b)) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
		
		sc.close();
	}
}
