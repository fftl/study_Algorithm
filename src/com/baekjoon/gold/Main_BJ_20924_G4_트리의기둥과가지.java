package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_20924_G4_트리의기둥과가지 {
	static int N, R, giga, gigaLen, maxLen;
	static ArrayList<ArrayList<Node>> arr;
	static boolean[] visited;
	
	public static class Node{
		int e, k;

		public Node(int e, int k) {
			this.e = e;
			this.k = k;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Node{");
			sb.append("e=").append(e);
			sb.append(", k=").append(k);
			sb.append('}');
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		if(N==1){
			System.out.println(0+" "+0);
			return;
		}

		arr = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			arr.get(s).add(new Node(e, k));
			arr.get(e).add(new Node(s, k));
		}
		
		visited = new boolean[N+1];
		findGiga();
		findMaxLen();
		
		System.out.println(gigaLen);
		System.out.println(maxLen);
	}
	
	static void findMaxLen() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {giga, 0});
		visited[giga] = true;
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			
			maxLen = Math.max(maxLen, now[1]);
			
			ArrayList<Node> nowNodes = arr.get(now[0]);
			for(Node n : nowNodes) {
				if(visited[n.e]) continue;
				
				visited[n.e] = true;
				q.add(new int[] {n.e, now[1]+n.k});
			}
		}
	}

	static void findGiga() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {R, 0});
		visited[R] = true;
		
		while(!q.isEmpty()) {
			if(q.size() == 1) {
				int[] now = q.poll();
				
				giga = now[0];
				gigaLen = now[1];
				
				ArrayList<Node> nowNodes = arr.get(now[0]);
				for(Node n : nowNodes) {
					if(visited[n.e]) continue;
					visited[n.e] = true;
					q.add(new int[] {n.e, now[1]+n.k});
				}
			} else {
				while(!q.isEmpty()) {
					visited[q.poll()[0]] = false;
				}
				break;
			}
		}
	}
}
