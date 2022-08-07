package com.bj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_1182_S2_부분수열의합 {
	static int[] arr;
	static int N, S, result;

	static void sumCheck(boolean[] visited) {
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				sum += arr[i];
				cnt++;
			}
		}
		if (cnt == 0)
			return;

		if (sum == S) {
			result++;
		}
		;

		return;
	}

	static void go(boolean[] visited, int cnt) {
		if (cnt == N) {
			sumCheck(visited);
			return;
		}

		visited[cnt] = false;
		go(visited, cnt + 1);

		visited[cnt] = true;
		go(visited, cnt + 1);

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		result = 0;

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		boolean[] now = new boolean[N];
		go(now, 0);

		System.out.println(result);
		sc.close();
	}

}
