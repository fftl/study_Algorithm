package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02480_B4_주사위세개 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[7];
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		arr[a]++;
		arr[b]++;
		arr[c]++;

		int max = 0;
		int maxVal = 0;
		for (int i = 1; i <= 6; i++) {
			if (arr[i] > 0 && arr[i] != 1) {
				max = i;
				maxVal = arr[i];
			}
		}

		int result = 0;
		if (maxVal == 3) {
			result = 10000 + (max * 1000);
		} else if (maxVal == 2) {
			result = 1000 + (max * 100);
		} else {
			for (int i = 6; i >= 1; i--) {
				if (arr[i] != 0) {
					result = i * 100;
					break;
				}
			}
		}

		System.out.println(result);
		sc.close();
	}
}
