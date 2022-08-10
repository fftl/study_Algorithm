package com.bj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_12851_G4_숨바꼭질2 {

	static int n, k;
	static int min;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		if (n > k) {
			System.out.println(n - k);
			System.out.println(1);
			sc.close();
			return;
		}

		if (n == k) {
			System.out.println(0);
			System.out.println(1);
			sc.close();
			return;
		}

		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		q.add(n);

		int min = 0;
		int result = 0;
		while (result == 0) {
			min++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				visited[now] = true;

				if (0 <= now + 1 && now + 1 <= 100000) {
					if (!visited[now + 1]) {
						if (now + 1 == k) {
							result++;
						} else {
							q.add(now + 1);
						}
					}
				}

				if (0 <= now - 1 && now - 1 <= 100000) {
					if (!visited[now - 1]) {
						if (now - 1 == k) {
							result++;
						} else {
							q.add(now - 1);
						}
					}
				}

				if (0 <= now * 2 && now * 2 <= 100000) {
					if (!visited[now * 2]) {
						if (now * 2 == k) {
							result++;
						} else {
							q.add(now * 2);
						}
					}
				}

				// 이번 문제의 경우 아래와같이 넣는 동시에 방문표시를 하면 길이 막혀버리는 효과를 줌!
				// n==1 이라면 n+1, n*2가 두가지 길로 갈라져야 하는데 n+1에서 방문처리가 되어버려 길이 줄어버림!
//				if (0<= now + 1 && now + 1 <= 100000) {
//					if (!visited[now + 1]) {
//						q.add(now + 1);
//						visited[now + 1] = true;
//					}
//				}
//
//				if (0 <= now - 1 && now - 1 <= 100000) {
//					if (!visited[now - 1]) {
//						q.add(now - 1);
//						visited[now - 1] = true;
//					}
//				}
//
//				if (0 <= now * 2 && now * 2 <= 100000) {
//					if (!visited[now * 2]) {
//						q.add(now * 2);
//						visited[now * 2] = true;
//					}
//				}

			}
		}

		System.out.println(min);
		System.out.println(result);
		sc.close();
	}

}
