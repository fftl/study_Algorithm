package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BJ_01927_S2_최소힙 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now == 0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else sb.append(pq.poll()+"\n");
			} else {
				pq.add(now);
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
