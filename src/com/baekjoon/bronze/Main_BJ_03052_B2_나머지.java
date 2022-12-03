package com.baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_03052_B2_나머지 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			int now = sc.nextInt();
			arr[i] = now % 42;
		}
		
		Arrays.sort(arr);
		
		int result = 1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i-1]) result++;
		}
		
		System.out.println(result);
		sc.close();
	}
}
