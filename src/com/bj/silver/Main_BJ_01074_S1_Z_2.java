package com.bj.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_01074_S1_Z_2 {

	static int size, hsize, N, r, c, result;
	static int[][] board;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		size = 1;
		result = 0;

		while (N > 0) {
			size *= 2;
			N--;
		}
		hsize = size / 2;
		System.out.println(size + "," + hsize);
		board = new int[size][size];

		int idx = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[i][j] = idx;
				idx++;
			}
		}

		while(size>1) {
			System.out.println("============");
			System.out.println(size + "," + hsize);
			System.out.println(r+","+c);
			System.out.println(result);
		}
		
		System.out.println(result+1);
		
		sc.close();
	}
}
