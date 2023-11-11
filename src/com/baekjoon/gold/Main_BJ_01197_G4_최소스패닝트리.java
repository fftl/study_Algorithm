package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_01197_G4_최소스패닝트리 {

	static class Node {
		int s, e, w;

		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}

	static int N, K;
	static int[] parent;
	static Node[] nodes;

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);

		if (aroot == broot)
			return false;

		parent[broot] = aroot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];

		for (int i = 1; i < N; i++) {
			parent[i] = i;
		}

		nodes = new Node[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(s, e, w);
		}

		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.w - o2.w;
			}
		});

		int cnt = 0;
		long result = 0;
		for (Node n : nodes) {
			if (union(n.s, n.e)) {
				result += n.w;
				cnt++;
			}
			if (cnt == N - 1)
				break;
		}

		System.out.println(result);
	}
}
