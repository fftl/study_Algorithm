package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01350_B2_진짜공간 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int size = Integer.parseInt(br.readLine());
		long result = 0;
		for (int i = 0; i < n; i++) {
			int now = nums[i];
			if(now == 0) continue;

			if(now>size) {
				if(now%size == 0) result += now/size;
				else result += (now/size) + 1;
			}
			else result++;
		}
		result = result*size;
		System.out.println(result);
	}
}
