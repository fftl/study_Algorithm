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

		//수빈이 위치가 동생위치보다 크다면 빼기연산을 하는 길밖에 없음 종료!
		if (n > k) {
			System.out.println(n - k);
			System.out.println(1);
			sc.close();
			return;
		}

		//둘의 시작 위치가 같다면 바로 종료!
		if (n == k) {
			System.out.println(0);
			System.out.println(1);
			sc.close();
			return;
		}

		Queue<Integer> q = new LinkedList<>();
		//수빈이가 갈수 있는 모든 범위를 visted에 담아서 다시 방문하지 않도록 합니다.
		boolean[] visited = new boolean[100001];
		q.add(n);

		int min = 0;
		int result = 0;
		
		while (result == 0) {	//만약 목적지에 한번이라도 도착하면 그게 최소값이므로 while을 멈출 예정입니다.
			
			min++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				visited[now] = true;

				//+1연산을 할 때 입니다.
				if (0 <= now + 1 && now + 1 <= 100000) {
					if (!visited[now + 1]) {
						if (now + 1 == k) {
							result++;
						} else {
							q.add(now + 1);
						}
					}
				}

				//-1연산을 할 때입니다.
				if (0 <= now - 1 && now - 1 <= 100000) {
					if (!visited[now - 1]) {
						if (now - 1 == k) { 
							result++;
						} else {
							q.add(now - 1);
						}
					}
				}

				//*2연산을 할 떄입니다.
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
