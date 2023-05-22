package com.baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_02668_G5_숫자고르기 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] base = new int[n+1];
		int[] arr = new int[n+1];
		boolean[] visited = new boolean[2];
		
		for (int i = 1; i <= n; i++) {
			base[i] = i;
			int num = sc.nextInt();
		}

		int result = 0;
		
		System.out.println(Arrays.toString(base));
		System.out.println(Arrays.toString(arr));
		
		sc.close();
	}
}
