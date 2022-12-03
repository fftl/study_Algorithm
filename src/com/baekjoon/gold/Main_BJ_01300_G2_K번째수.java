package com.baekjoon.gold;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BJ_01300_G2_K번째수 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextInt();
		
		long[][] board = new long[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				board[i][j] = i*j;
			}
		}
		
		System.out.println(Arrays.deepToString(board));
		sc.close();
	}
}
