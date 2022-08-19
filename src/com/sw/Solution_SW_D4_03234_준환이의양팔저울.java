package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D4_03234_준환이의양팔저울 {

	static int n, cnt, allCnt;
	static int[] arr, result;
	static boolean[] visited;

	static void check(int left, int right, int depth) {
		if (depth == n) {
			allCnt++;
			return;
		}

		check(left + result[depth], right, depth + 1);
		if (right + result[depth] <= left) {
			check(left, right + result[depth], depth + 1);
		}
	}

	static void permu(int cnt) {
		if (cnt == n) {
			check(0, 0, 0);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[cnt] = arr[i];
				permu(cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sw_input_3234.txt")); // input 가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			allCnt = 0;
			n = Integer.parseInt(br.readLine());
			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			result = new int[n];
			visited = new boolean[n];
			permu(0);

			System.out.println(allCnt);
			break;
		}
	}

}
