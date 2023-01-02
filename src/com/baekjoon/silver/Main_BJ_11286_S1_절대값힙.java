package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_BJ_11286_S1_절대값힙 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if(Math.abs(a) != Math.abs(b)) {
					return Integer.compare(Math.abs(a), Math.abs(b));
				} else {
					return Integer.compare(a, b);
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now != 0) {
				pq.add(now);
			} else {
				if(pq.isEmpty()) {
					sb.append(0+"\n");
				} else {
					sb.append(pq.poll()+"\n");
				}
			}
		}
		
		System.out.println(sb.toString().trim());
		
		
	}
}
