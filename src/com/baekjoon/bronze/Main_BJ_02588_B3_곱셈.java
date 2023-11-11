package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02588_B3_곱셈 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[] na = new int[3];
		int[] nb = new int[3];
		
		String sa = Integer.toString(a);
		String sb = Integer.toString(b);
		for (int i = 0; i < 3; i++) {
			na[i] = sa.charAt(i)-'0';
			nb[i] = sb.charAt(i)-'0';
		}
		
		int res1 = 0; 
		int res2 = 0;
		int res3 = 0;
		
		for(int i=0; i<3; i++) {
			int result = 0;
			int now = nb[2-i];
			for (int j = 0; j < 3; j++) {
				int nowV = na[2-j];
				if(j!=0) {
					if(j==1) result += nowV*now*10;
					else  result += nowV*now*100;
				} else {
					result += nowV*now;
				}
			}
			
			if(i==1) res2 = result*10;
			else if(i==2) res3 = result*100;
			else res1 = result;
		}
		
		System.out.println(res1);
		System.out.println(res2/10);
		System.out.println(res3/100);
		System.out.println(res1+res2+res3);
		sc.close();
	}
}
