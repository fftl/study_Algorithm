package com.bj;

import java.util.Scanner;

public class Main_BJ_01_메모 {
	static int A, B, cnt;
	
	static void dfs(int a, int b) {
		if(a==A) {
			System.out.println("a >> " + a + " b >> " + b);
			cnt++;
			return;
		}
		
		for (int i = a; i<A; i++) {
			for (int j = b; j < B; j++) {
				dfs(i+1, b+1);
			}
		}
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T-1; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			
			cnt = 0; 
			
			dfs(0, 0);
			System.out.println(cnt);
		}
		sc.close();
	}
}
