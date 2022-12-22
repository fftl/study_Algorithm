package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01614_S3_영식이의손가락 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		if(n==0) {
			System.out.println(a-1);
			return;
		}
		
		long result = 0;
		if(n%2!=0) {
			if(a==5) {
				result = 12+(8*(n-1));
			} else {
				result = 5+(4*(n-1))+(4-a)%4;
			}
		} else {
			if(n==1) {
				result = 8*(n-1);
			} else {
				result = 5+(4*(n-1))+a-2;
			}
		}
		
		System.out.println(result);
	}
}
