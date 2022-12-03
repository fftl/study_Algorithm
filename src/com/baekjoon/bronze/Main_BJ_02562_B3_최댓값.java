package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02562_B3_최댓값 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		int maxIdx = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		System.out.println(max);
		System.out.println(maxIdx+1);
		sc.close();
	}
}
