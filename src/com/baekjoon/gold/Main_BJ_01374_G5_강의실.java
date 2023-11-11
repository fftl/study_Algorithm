package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01374_G5_강의실 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Time> pq = new PriorityQueue<>(new Comparator<Time>() {
			@Override
			public int compare(Time o1, Time o2) {
				if(o1.s == o2.s) {
					return o1.e-o2.e;
				} else {
					return o1.s-o2.s;
				}
			}		
		});
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			pq.add(new Time(num, s, e));
		}
		
		PriorityQueue<Time> out = new PriorityQueue<>(new Comparator<Time>() {
			@Override
			public int compare(Time o1, Time o2) {
					return o1.e-o2.e;
				}
		});
		
		out.add(pq.poll());
		int result = 1;
		
		while(!pq.isEmpty()) {
			Time now = pq.peek();
			if(out.isEmpty()) {
				out.add(pq.poll());
			} else {
				Time first = out.peek();
				if(now.s < first.e) {
					out.add(pq.poll());
				} else {
					out.poll();
				}
			}
			
			if(!out.isEmpty()) result = Math.max(result, out.size());
		}
		
		System.out.println(result);
	}
	
	static class Time{
		int idx, s, e;

		public Time(int idx, int s, int e) {
			super();
			this.idx = idx;
			this.s = s;
			this.e = e;
		}

		@Override
		public String toString() {
			return "Time [idx=" + idx + ", s=" + s + ", e=" + e + "]";
		}
		
		
	}
}
