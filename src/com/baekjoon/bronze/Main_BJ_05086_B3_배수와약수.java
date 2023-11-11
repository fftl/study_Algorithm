package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_05086_B3_배수와약수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==0 && b==0) break;
			
			if(a<=b) {
				if(b%a==0) {
					System.out.println("factor");
				} else {
					System.out.println("neither");
				}
			} else if (a>=b) {
				if(a%b==0) {
					System.out.println("multiple");
				} else {
					System.out.println("neither");
				}
			}
		}
	}
}
