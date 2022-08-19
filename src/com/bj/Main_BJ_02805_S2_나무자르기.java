package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_02805_S2_나무자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		int max = 0; // 제일 큰 나무의 높이를 구해줍니다.
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			max = Math.max(num, max);
		}
		
		int[] memo = new int[max+1];
		boolean[] visited = new boolean[max+1];

		Arrays.sort(arr);
		int s = 0;
		int e = max;
		int mid = 0;
		
		while (s < e) {
			mid = (s + e) / 2;
			long nowSum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (mid < arr[i]) {
					nowSum += arr[i] - mid;
				}
			}
			
			visited[mid] = true;
			memo[mid] = (int) nowSum;
			
			if (nowSum == k) {
				break;

			} else if (nowSum > k) {
				s = mid + 1;

			} else {
				e = mid - 1;
			}
		}

		System.out.println(mid);
	}
}
