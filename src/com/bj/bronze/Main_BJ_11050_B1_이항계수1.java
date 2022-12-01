package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_11050_B1_이항계수1 {
	
	static int result;
	
	static void comb(int k, int cnt, int s, int n) {
		if(cnt == k) {
			result++;
			return;
		}
		
		for (int i = s; i < n; i++) {
			comb(k, cnt+1, i+1, n);
		}
		
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		result = 0;
		comb(k, 0, 0, n);
		
		System.out.println(result);
		sc.close();
	}
}
