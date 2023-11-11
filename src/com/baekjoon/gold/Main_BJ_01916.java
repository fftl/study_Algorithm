package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다익스트라!
public class Main_BJ_01916_G5_최소비용구하기 {
	
	static ArrayList<ArrayList<Node>> graph;
	static boolean[] visited;
	static int[] dist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		visited = new boolean[n+1];
		dist = new int[n+1];
		graph = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			dist[i] = Integer.MAX_VALUE;
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			graph.get(s).add(new Node(e, k));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				return a.k - b.k;
			}
		});
		
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visited[now.n]) visited[now.n] = true;
			if(dist[now.n] < now.k) continue;
			
			for(Node next : graph.get(now.n)) {
				if(!visited[next.n] && dist[next.n] > now.k+next.k) {
					dist[next.n] = now.k + next.k;
					pq.add(new Node(next.n, dist[next.n]));
				}
			}
		}
		
		System.out.println(dist[end]);
	}
	
	static class Node{
		int n, k;
		public Node(int n, int k) {
			super();
			this.n = n;
			this.k = k;
		}
		@Override
		public String toString() {
			return "Node [n=" + n + ", k=" + k + "]";
		}
	}
}
