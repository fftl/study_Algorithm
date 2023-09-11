package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_01781_G2_컵라면 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		boolean[] deadCheck = new boolean[n+1];
		list.add(new int[] {0,0,0});
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int dead = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			deadCheck[dead] = true;
			
			list.add(new int[] {dead, cnt, i});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o2[1]-o1[1];
				} else {
					return o1[0]-o2[0];
				}
			}
		});

		long result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int[] now : list){
			if(now[0]==0)continue;

			int size = pq.size();
			if(size<now[0]){
				pq.offer(now[1]);
			}
			else if(size == now[0]){
				int nCount = pq.peek();
				if(nCount < now[1]){
					pq.poll();
					pq.offer(now[1]);
				}
			}
		}

		while(!pq.isEmpty()){
			result += pq.poll();
		}


		System.out.println(result);
		
		
	}
}
