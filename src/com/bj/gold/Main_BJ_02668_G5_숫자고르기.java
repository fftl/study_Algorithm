package com.bj.gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_02668_G5_숫자고르기 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] base = new int[n+1];
		int[] arr = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			base[i] = i;
			arr[i] = sc.nextInt();
		}
		
		System.out.println(Arrays.toString(base));
		System.out.println(Arrays.toString(arr));
		
		sc.close();
	}
}
