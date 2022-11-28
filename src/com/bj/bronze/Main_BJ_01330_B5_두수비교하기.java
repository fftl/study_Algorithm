package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_01330_B5_두수비교하기 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>b) System.out.println(">");
		else if(a<b) System.out.println("<");
		else System.out.println("==");
		sc.close();
	}
}
