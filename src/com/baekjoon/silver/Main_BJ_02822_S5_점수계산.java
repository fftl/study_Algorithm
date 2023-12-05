package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main_BJ_02822_S5_점수계산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int[] sort = new int[9];
		for (int i = 1; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sort[i] = arr[i];
		}

		Arrays.sort(sort);
		int sum = 0;
		HashSet<Integer> check = new HashSet<>();
		for (int i = 8; i >= 4; i--) {
			sum += sort[i];
			check.add(sort[i]);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(sum+"\n");

		for (int i = 1; i < 9; i++) {
			if(check.contains(arr[i])){
				sb.append(i+" ");
			}
		}
		System.out.println(sb.toString().trim());

	}
}
