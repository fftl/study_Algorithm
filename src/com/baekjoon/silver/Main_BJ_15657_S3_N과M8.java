package com.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_15657_S3_N과M8 {

	static int n, m;
	static int[] nums;
	static StringBuilder sb;

	static void permutation(int s, int cnt, String strs) {
		if (cnt == m) {
			sb.append(strs.trim() + "\n");
			return;
		}

		for (int i = s; i < n; i++) {
				permutation(i, cnt + 1, strs + " " + nums[i]);
		}
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sb = new StringBuilder();
		nums = new int[n];
		
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);

		permutation(0, 0, "");

		System.out.println(sb.toString());

		sc.close();
	}
}
