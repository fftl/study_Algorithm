package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01238_G3_파티 {
	
	static int N, M, X; //1000, 10,000, 1<= X <=N
	static ArrayList<ArrayList<Node>> nodes;
	
	//출발, 도착, 가는데 걸리는 시간을 담아줄 Node 입니다.
	static class Node{
		int e, v;
		public Node(int e, int v) {
			super();
			this.e = e;
			this.v = v;
		}
		@Override
		public String toString() {
			return "Node [e=" + e + ", v=" + v + "]";
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		int result = 0;
		
		nodes = new ArrayList<>();
		for (int i = 0; i <= N; i++) nodes.add(new ArrayList<>()); 
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			nodes.get(s).add(new Node(e, v));
		}
		
		int[] xdist = new int[N+1];
		Arrays.fill(xdist, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.v, o2.v);
			}
		});
		
		pq.add(new Node(X, 0));
		xdist[X] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			//이번에 now.e에 갈 수 있는 방법(크기보다) 이미 더 작은 크기로 해당 위치에 도착했었다면 이번 탐색을 끝냅니다.
			if(xdist[now.e] < now.v) {
				continue;
			}
			
			//현재 노드에서 이동할 수 있는 경로들을 탐색합니다.
			for (int i = 0; i < nodes.get(now.e).size(); i++) {
				Node nxtNode = nodes.get(now.e).get(i); //갈수 있는 경로 nxtNode
				
				
				if(xdist[nxtNode.e] > now.v+nxtNode.v) {
					xdist[nxtNode.e] = now.v+nxtNode.v;
					pq.add(new Node(nxtNode.e, xdist[nxtNode.e]));
				}
			}
		}
		
		int[] dist = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if(i==X) continue;
			Arrays.fill(dist, Integer.MAX_VALUE);
			pq.clear();
			pq.add(new Node(i, 0));
			dist[i] = 0;
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				
				if(dist[now.e] < now.v) {
					continue;
				}
				
				for (int j = 0; j < nodes.get(now.e).size(); j++) {
					Node nxtNode = nodes.get(now.e).get(j);
					
					if(dist[nxtNode.e] > now.v+nxtNode.v) {
						dist[nxtNode.e] = now.v+nxtNode.v;
						pq.add(new Node(nxtNode.e, dist[nxtNode.e]));
					}
				}
			}
			
			result = Math.max(result, xdist[i]+dist[X]);
		}
		
		System.out.println(result);
		
	}
}
