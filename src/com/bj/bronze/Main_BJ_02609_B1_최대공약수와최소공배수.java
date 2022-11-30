package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_02609_B1_최대공약수와최소공배수 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(gdc(a, b));
		System.out.println(lcm(a, b));
		
		sc.close();
	}
	
	static int gdc(int a, int b) {
		if(a<b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
	static int lcm(int a, int b) {
		return a*b / gdc(a,b);
	}
}
