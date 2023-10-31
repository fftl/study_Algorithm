package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_01021_S3_회전하는큐 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];

		for (int i = 1; i < N+1; i++) {
			arr[i] = i;
		}

		int size = N;
		int res = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			System.out.println(Arrays.toString(arr));
			int now = Integer.parseInt(st.nextToken());

			if(arr[now] == 1) {
				for (int j = 1; j < N+1; j++) {
					arr[j] -= 1;
				}
			} else if (arr[now] <= size-arr[now]){
				res += arr[now];
				size -= arr[now];
				for (int j = 1; j < size; j++) {
					arr[j] = arr[j] - (arr[now] - 1) < 1 ? size - (arr[j] - (arr[now] - 1)) : arr[j] - (arr[now] - 1);
				}
			} else {
				res += size-arr[now];
				size -= size-arr[now];
				for (int j = 1; j < size; j++) {
					arr[j] = arr[j] + (size-arr[now]) <= size ? (size-arr[now])  : arr[j] + (size-arr[now])-size;
				}

			}
		}

		System.out.println(res);
	}
}
