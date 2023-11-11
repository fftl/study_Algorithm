package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_11779_G3_최소비용구하기2 {
	static int n, m, resS, resE;
	static ArrayList<ArrayList<Node>> nodes;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		nodes = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			nodes.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			nodes.get(s).add(new Node(e, k));
		}
		
		st = new StringTokenizer(br.readLine());
		resS = Integer.parseInt(st.nextToken());
		resE = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n+1];
		int[] route = new int[n+1];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.k-o2.k;
			}
		});
		
		pq.add(new Node(resS, 0));
		dist[resS] = 0;
		route[resS] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			if (dist[curNode.idx] < curNode.k) {
				continue;
			}
			
			for (int i = 0; i < nodes.get(curNode.idx).size(); i++) {
				Node nxtNode = nodes.get(curNode.idx).get(i);
				
				if (dist[nxtNode.idx] > curNode.k + nxtNode.k) {
					dist[nxtNode.idx] = curNode.k + nxtNode.k;
					// 갱신된 경우에만 큐에 넣는다.
					pq.add(new Node(nxtNode.idx, dist[nxtNode.idx]));
					route[nxtNode.idx] = curNode.idx;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[resE]+"\n");
		
		int root = resE;
		Stack<Integer> stack = new Stack<>();
		while(root != resS) {
			stack.add(root);
			root = route[root];
		}
		
		sb.append((stack.size()+1)+"\n");
		sb.append(resS+" ");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	static class Node{
		int idx, k;
		
		public Node(int idx, int k) {
			this.idx = idx;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", k=" + k + "]";
		}
	}
}
