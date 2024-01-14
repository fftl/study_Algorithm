package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01895_S4_필터 {
	static int Y, X, T;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		int[][] arr = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		T = Integer.parseInt(br.readLine());

		int result = 0;
		for (int i = 0; i < Y-2; i++) {
			for (int j = 0; j < X-2; j++) {
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				for (int k = i; k < i+3; k++) {
					for (int l = j; l < j+3; l++) {
						pq.add(arr[k][l]);
					}
				}

				for (int k = 0; k < 4; k++) pq.poll();
				int mid = pq.poll();
				if(mid>=T) result++;
			}
		}

		System.out.println(result);
	}
}
