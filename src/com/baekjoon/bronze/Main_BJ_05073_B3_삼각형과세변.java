package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_05073_B3_삼각형과세변 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(a==0 && b==0 && c==0) break;
			else {
				int max = Math.max(c, Math.max(a, b));
				if(max == c) {
					if(max>=a+b) { 
						System.out.println("Invalid");
						continue; 
					}
				} else if(max == b) {
					if(max>=a+c) { 
						System.out.println("Invalid");
						continue;
					}
				} else if(max == a) {
					if(max>=b+c)  { 
						System.out.println("Invalid");
						continue;
					}
				}
				
				
				if(a==b && b==c) {
					System.out.println("Equilateral");
				} else if(a==b || b==c || a==c) {
					System.out.println("Isosceles");
				} else {
					System.out.println("Scalene");
				}
			}
		}
	}
}
