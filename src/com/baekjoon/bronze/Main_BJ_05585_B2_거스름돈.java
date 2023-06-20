package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_05585_B2_거스름돈 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 1000-Integer.parseInt(br.readLine());
		
		int res = 0;
		while(n>0) {
			if( n/500 > 0) {
				res += n/500;
				n = n%500;
			} else if( n/100 > 0) {
				res += n/100;
				n = n%100;
			} else if( n/50 > 0) {
				res += n/50;
				n = n%50;
			} else if( n/10 > 0) {
				res += n/10;
				n = n%10;
			} else if( n/5 > 0) {
				res += n/5;
				n = n%5;
			} else {
				res += n;
				n = 0;
			}
		}
		
		System.out.println(res);
	}
}
