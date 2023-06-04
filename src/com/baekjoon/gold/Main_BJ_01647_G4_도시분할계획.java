package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_01647_G4_도시분할계획 {
	static int N, M;
	static int[] parent;
	
	static class Node{
		int a, b, v;
		public Node(int a, int b, int v) {
			this.a = a;
			this.b = b;
			this.v = v;
		}
		public String toString() {
			return a+","+b+","+v;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//parent를 초기화 해줍니다.
		parent = new int[N+1];
		for (int i = 0; i<=N; i++) parent[i] = i;
		
		ArrayList<Node> arr = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr.add(new Node(a, b, v));
		}
		
		Collections.sort(arr, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.v-o2.v;
			}
		});
		
		int ans = 0;
		int maxCost = 0;
		for (int i = 0; i < arr.size(); i++) {
			Node node = arr.get(i);
			if(find(node.a) != find(node.b)) {
				ans += node.v;
				union(node.a, node.b);
				maxCost = node.v;
			}
		}
		
		System.out.println(ans-maxCost);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) parent[y] = x;
	}
	
	static int find(int num) {
		if(parent[num] == num) return num;
		else return parent[num] = find(parent[num]);
	}
	
}
