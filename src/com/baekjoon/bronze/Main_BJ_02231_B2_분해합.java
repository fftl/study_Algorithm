package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02231_B2_분해합 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = Integer.MAX_VALUE;
		
		for (int i = n-1; 0 <= i; i--) {
			int now = i;
			String sNum = Integer.toString(i);
			for (int j = 0; j < sNum.length(); j++) {
				now += sNum.charAt(j)-'0';
			}
			if(now == n) {
				result = Math.min(result, i);
			}
		}
		
		if(result == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(result);
		
		sc.close();
	}
}
