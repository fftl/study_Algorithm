package com.bj.silver;

import java.util.Scanner;

public class Main_BJ_06603_S2_로또_00 {

	static int[] nums;
	static int[] results;
	static int cnt;

	static void comb(int cnt, int start) {
		if (cnt == 6) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < results.length; i++) {
				sb.append(results[i]+" ");
			}
			System.out.println(sb.toString().trim());
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			results[cnt] = nums[i];
			comb(cnt+1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		while (cnt != 0) {
			nums = new int[cnt];
			results = new int[6];

			for (int i = 0; i < cnt; i++) {
				nums[i] = sc.nextInt();
			}

			comb(0, 0);

			cnt = sc.nextInt();
			System.out.println();
		}

		sc.close();
	}// main
}// class
