package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_01865_G3_웜홀 {
	
	static class Road {
		int end;
		int weight;
		public Road(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Road [end=" + end + ", weight=" + weight + "]";
		}
	}
	
	static int N, M, W;
	static int[] dist;
	static ArrayList<ArrayList<Road>> a;
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 1<=N<=500
			M = Integer.parseInt(st.nextToken()); // 1<=M<=2500
			W = Integer.parseInt(st.nextToken()); // 1<=W<=200
			
			dist = new int[N+1];
			a = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				a.add(new ArrayList<>());
			}
			
			for (int i = 0; i < M+W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				if(i<M) { //도로는 양방향 그래프
					a.get(s).add(new Road(e, w));
					a.get(e).add(new Road(s, w));
				} else { //웜홀은 단방향 그래프
					a.get(s).add(new Road(e, -w));
				}
			}
			
			boolean isMinusCycle = false;
			for (int i = 1; i <= N; i++) {
				if(bellman(i)) {
					isMinusCycle = true;
					sb.append("YES\n");
					break;
				}
			}
			
			if(!isMinusCycle) {
				sb.append("NO\n");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
	
	public static boolean bellman(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean update = false;
		
		for (int i = 1; i < N; i++) {
			update = false;
			for (int j = 1; j <= N; j++) {
				for(Road road : a.get(j)) {
					if(dist[j] != INF && dist[road.end] > dist[j] + road.weight) {
						dist[road.end] = dist[j] + road.weight;
						update = true;
					}
				}
			}
			
			if(!update) {
				break;
			}
		}
		
		if(update) {
			for (int i = 1; i <= N; i++) {
				for (Road road : a.get(i)) {
					if(dist[i] != INF && dist[road.end] > dist[i] + road.weight) {
						return true;
					}
					
				}
			}
		}
		
		return false;
	}
}
