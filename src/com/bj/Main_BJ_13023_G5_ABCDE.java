package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_13023_G5_ABCDE {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[2001];

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr.get(a).add(b);
			arr.get(b).add(a);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int C = 0;
			if (!visited[i]) {
				q.add(i);
				visited[i] = true;
				while (!q.isEmpty()) {
					C++;
					int size = q.size();
					int now = q.poll();
					ArrayList<Integer> nowArr = arr.get(now);
					for (int j = 0; j < nowArr.size(); j++) {
						if (!visited[nowArr.get(j)]) {
							visited[nowArr.get(j)] = true;
							q.add(nowArr.get(j));
						}
					}
				}
			}
			
			max = Math.max(C, max);
		}

		if (max >= 5) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
