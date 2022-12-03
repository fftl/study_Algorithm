package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01003_S3_피보나치함수 {
	
	static int zero, one;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			zero = 0;
			one = 0;
			int k = Integer.parseInt(br.readLine());
			
			fibo(k);
			System.out.println(zero+" "+one);
		}
	}
	
	static int fibo(int k) {
		if(k == 0) {
			zero++;
			return 0;
		} else if(k == 1) {
			one++;
			return 1;
		} else {
			return fibo(k-1) + fibo(k-2);
		}
	}
}
