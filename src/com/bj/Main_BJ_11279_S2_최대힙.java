package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_BJ_11279_S2_최대힙 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pque = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -(o1 - o2);
			}
		});

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				if (pque.isEmpty())
					System.out.println(0);
				else
					System.out.println(pque.poll());
			} else {
				pque.add(n);
			}
		}
	}
}
