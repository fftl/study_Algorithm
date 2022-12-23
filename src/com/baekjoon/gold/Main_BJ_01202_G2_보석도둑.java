package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01202_G2_보석도둑 {
	
	static class Jewel{
		long w, v;
		public Jewel(long w, long v) {
			super();
			this.w = w;
			this.v = v;
		}
		@Override
		public String toString() {
			return "Jewel [w=" + w + ", v=" + v + "]";
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Jewel[] arr = new Jewel[n];
		long[] bag = new long[k];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long w = Long.parseLong(st.nextToken());
			long v = Long.parseLong(st.nextToken());
			arr[i] = new Jewel(w, v);
		}
		
		Arrays.sort(arr, new Comparator<Jewel>() {
			@Override
			public int compare(Jewel o1, Jewel o2) {
				if(o1.w != o2.w) {
					return Long.compare(o1.w, o2.w);
				} else {
					return Long.compare(o2.v, o1.v);
				}
			}
		});
		
		for (int i = 0; i < k; i++) {
			bag[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(bag);
		
		PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long ans = 0;
		
		for (int i=0, j=0; i < k; i++) {
			while(j<n && arr[j].w<=bag[i]) {
				pq.add(arr[j++].v);
			}
			
			if(!pq.isEmpty()) {
				ans+=pq.poll();
			}
		}
		
		System.out.println(ans);
	}
}
