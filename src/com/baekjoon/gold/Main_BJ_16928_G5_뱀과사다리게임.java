package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16928_G5_뱀과사다리게임 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] info = new int[101];
		int[] dist = new int[101];
//		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			info[s] = e;
		}
		
		dist[1] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		int depth = 1;
		run : while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				for (int j = 1; j <= 6; j++) {
					int next = now+j;
					if(next>=100) break run;
					
					if(dist[next] == 0) {
						if(info[next] == 0) {
							dist[next] = depth;
							q.add(next);
						} else {
							dist[next] = depth;
							dist[info[next]] = depth;
							q.add(info[next]);
						}
					}
				}
			}
			depth++;
		}
		
		System.out.println(Arrays.toString(dist));
		System.out.println(depth);
		
		
	}
}
