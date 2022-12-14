package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01753_G4_최단경로 {
	
	static int[] dist;
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> graph;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //정점의 개수 1<= V <= 20,000
		int E = Integer.parseInt(st.nextToken()); //간선의 개수 1<= E <= 300,000
		int K = Integer.parseInt(br.readLine()); //시작 정점 1<= K <=V 
		
		dist = new int[V+1];
		visited = new boolean[V+1];
		graph = new ArrayList<>();
		
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e, k));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.k-o2.k;
			}
		});
		
		dist[K] = 0;
		pq.add(new Node(K, 0));
		
		while(!pq.isEmpty()) {
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				
				Node now = pq.poll();
				if(!visited[now.n]) visited[now.n] = true;
				
				for(Node next : graph.get(now.n)) {
					//아직 방문하지 않은 노드이고 시작노드로부터 now.k+next.k
					if(!visited[next.n] && dist[next.n] > now.k+next.k) {
						dist[next.n] = now.k + next.k;
						pq.add(new Node(next.n, dist[next.n]));
					}
				}
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i]+"\n");
		}
		
		System.out.println(sb.toString().trim());
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
