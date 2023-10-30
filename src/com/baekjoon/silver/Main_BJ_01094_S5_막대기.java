package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01094_S5_막대기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int now = 64;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(64);

		while(t != now){
			int num = pq.poll();
			int half = num/2;

			if(now-half>=t){
				pq.add(half);
				now -= half;
			} else {
				pq.add(half);
				pq.add(half);
			}
		}

		System.out.println(pq.size());
	}
}
