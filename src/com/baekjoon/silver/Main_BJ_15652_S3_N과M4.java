package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_15652_S3_N과M4 {

	static int n, m;
	static StringBuilder sb;

	static void permutation(int s, int cnt, String strs) {
		if (cnt == m) {
			sb.append(strs.trim() + "\n");
			return;
		}

		for (int i = s; i <= n; i++) {
			permutation(i, cnt + 1, strs + " " + i);
		}
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sb = new StringBuilder();

		permutation(1, 0, "");

		System.out.println(sb.toString());

		sc.close();
	}
}
