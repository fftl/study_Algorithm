package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01715_G4_카드정렬하기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		//우선순위 큐를 사용! 오름차순으로 정렬 되도록
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		//pq를 만들어줍니다.
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int result = 0;
		while(!pq.isEmpty()) {
			//두개씩 꺼내주며 그의 합을 result에 더해주고 다시 pq에 넣어줍니다.
			//만약 하나가 남았다면 하나만 꺼내서 종료!
			if(pq.size()>=2) {
				int a = pq.poll();
				int b = pq.poll();
				result += a+b;
				pq.add(a+b);
			} else {
				break;
			}
		}
		
		System.out.println(result);
	}
}
