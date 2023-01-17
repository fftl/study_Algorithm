package com.baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_10817_B3_세수 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		Arrays.sort(arr);
		
		System.out.println(arr[1]);
		sc.close();
	}
}
