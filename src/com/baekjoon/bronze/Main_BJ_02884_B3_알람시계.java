package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02884_B3_알람시계 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		m -= 45;
		
		if(m<0) {
			m += 60;
			h -= 1;
			if(h<0) h = 23;
		}
		
		System.out.println(h + " " + m);
		sc.close();
	}
}
