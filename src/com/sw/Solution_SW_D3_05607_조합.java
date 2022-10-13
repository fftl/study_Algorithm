package com.sw;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_SW_D3_05607_조합 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sw_input_5607.txt")); // input 가져오기
		Scanner sc = new Scanner(System.in);
		int k = 1234567891;
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int r = sc.nextInt();

			long a = 1, b = 1;
			long t = Math.min(r, n - r);

			for (int i = 0; i < t; i++) {
				a = a * (n - i) % k;
				b = b * (t - i) % k;
			}

			long result = (a % k * div(b, k - 2, k) % k) % k;
			System.out.println("#" + tc + " " + result);
		}

		sc.close();
	}

	static long div(long a, long b, int k) {
		if (b == 1)
			return a;

		long temp = div(a, b / 2, k);

		if (b % 2 == 1)
			return temp * temp % k * a % k;
		else
			return temp * temp % k;

	}
}
