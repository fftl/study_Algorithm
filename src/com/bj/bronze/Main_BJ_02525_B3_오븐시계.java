package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_02525_B3_오븐시계 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		int cnt = sc.nextInt();
		
		m += cnt;
		
		if(m/60>0) {
			h += m/60;
			m = m%60;
		}
		
		if(h>23) {
			h = h%24;
		}
		
		System.out.println(h+" "+m);
		sc.close();
	}
}
