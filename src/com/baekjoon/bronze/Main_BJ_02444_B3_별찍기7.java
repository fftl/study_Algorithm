package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02444_B3_별찍기7 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int g = n-1;
		for (int i = 1; i <= 2*n-1; i+=2) {
			for (int j = 0; j < g; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
			g--;
		}
		g++;
		for (int i = 2*n-3; i >= 1; i-=2) {
			g++;
			for (int j = 0; j < g; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
