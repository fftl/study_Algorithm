package com.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_01074_S1_Z {

	static int size, hsize, N, r, c, result;
	static int[][] board;

	static void div() {
		// 좌상단
		if (r < hsize && c < hsize) {
			System.out.println("section"+1);
			// 우상단
		} else if (r < hsize && hsize <= c) {
			System.out.println("section"+2);
			result += hsize*hsize*1;
			// 좌하단
		} else if (hsize <= r && c < hsize) {
			System.out.println("section"+3);
			result += hsize*hsize*2;
			// 우하단
		} else {
			System.out.println("section"+4);
			result += hsize*hsize*3;
		}
		
		r = r-hsize<0 ? 0 : r-hsize;
		c = c-hsize<0 ? 0 : c-hsize;
		size /= 2;
		hsize = size/2;
	}

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
			div();
			System.out.println(size + "," + hsize);
			System.out.println(r+","+c);
			System.out.println(result);
		}
		
		System.out.println(result+1);
		
		sc.close();
	}
}
