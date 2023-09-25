package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_17009_B4_WinningScore {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 0; 
		int b = 0;
		for (int i = 3; i >= 1; i--) {
			int n = Integer.parseInt(br.readLine());
			a += n*i;
		}

		for (int i = 3; i >= 1; i--) {
			int n = Integer.parseInt(br.readLine());
			b += n*i;
		}

		if(a>b) System.out.println("A");
		else if(a<b) System.out.println("B");
		else System.out.println("T");
	}
}
