package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_01074_S1_Z {
	static int count = 0;
	static void find(int size, int y, int x) {
		if(size == 1) return ;
		if(y<size/2 && x<size/2) {
			find(size/2, y, x);
		} else if(y<size/2 && x>=size/2) {
			count += size * size/4;
			find(size/2, y, x-size/2);
		} else if(y>=size/2 && x<size/2) {
			count +=(size * size/4) *2;
			find(size/2, y-size/2, x);
		} else {
			count += (size * size/4) *3;
			find(size/2, y-size/2, x-size/2);
		}
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int y = sc.nextInt();
		int x = sc.nextInt();
		
		int size = (int) Math.pow(2, n);
		find(size, y, x);
		System.out.println(count);
		sc.close();
	}
}
