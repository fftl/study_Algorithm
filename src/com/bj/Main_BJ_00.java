package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_00 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int result = 0;
		while(!pq.isEmpty()) {
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
