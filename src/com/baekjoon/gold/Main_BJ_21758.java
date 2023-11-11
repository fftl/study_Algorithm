package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_21758_G5_꿀따기 {
	static int n;
	static int[] honeys;
	static long maxCount, total;
	static long[] right, left;

	static void case1() {
		long bee1, bee2;

		for (int i = 1; i <= n - 2; i++) {
			bee1 = total - honeys[0] - honeys[i];
			bee2 = total - right[i];
			maxCount = Math.max(maxCount, bee1 + bee2);
		}
	}

	static void case2() {
		long bee1, bee2;

		for (int i = n-2; i >= 1; i--) {
			bee1 = total - honeys[n-1] - honeys[i];
			bee2 = total - left[i];
			maxCount = Math.max(maxCount, bee1 + bee2);
		}
	}

	static void case3() {
		long bee1, bee2;

		for (int i = 1; i <= n-2; i++) {
			bee1 = right[i] - honeys[0];
			bee2 = left[i] -  honeys[n-1];
			maxCount = Math.max(maxCount, bee1 + bee2);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		honeys = new int[n];
		right = new long[n];
		left = new long[n];
		long temp = 0;
		for (int i = 0; i < n; i++) {
			honeys[i] = Integer.parseInt(st.nextToken());
			temp += honeys[i];
			right[i] = temp;
		}

		temp = 0;
		for (int i = n - 1; i >= 0; i--) {
			temp += honeys[i];
			left[i] = temp;
		}

		total = right[n - 1];
		case1();
		case2();
		case3();
		System.out.println(maxCount);
	}
}
