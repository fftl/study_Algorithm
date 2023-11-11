package com.baekjoon.gold;

import java.util.*;
import java.io.*;

public class Main_BJ_14938_G4_서강그라운드 {
	static int N, M, R, result;
	static ArrayList<ArrayList<Node>> nodes;
	static int[] val;

// tip: arguments are passed via the field below this editor
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		val = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}

		nodes = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			nodes.add(new ArrayList<>());

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			nodes.get(s).add(new Node(e, k));
			nodes.get(e).add(new Node(s, k));
		}

		int[] dist = null;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.k, o2.k);
			}
		});

		for (int i = 1; i <= N; i++) {
			dist = new int[N + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[i] = 0;

			pq.add(new Node(i, 0));

			while (!pq.isEmpty()) {
				Node now = pq.poll();
				if (dist[now.e] < now.k)
					continue;

				for (int j = 0; j < nodes.get(now.e).size(); j++) {
					Node next = nodes.get(now.e).get(j);

					if (dist[next.e] > next.k + now.k) {
						dist[next.e] = next.k + now.k;
						pq.add(new Node(next.e, dist[next.e]));
					}
				}
			}

			int nowRes = 0;
			for (int j = 1; j < dist.length; j++) {
				// 갈 수 있는 거리라면
				if (dist[j] <= M) {
					nowRes += val[j];
				}
			}

			result = Math.max(result, nowRes);
		}

		System.out.println(result);
	}

	static class Node {

		int e, k;

		public Node(int e, int k) {
			this.e = e;
			this.k = k;
		}

		public String toString() {
			return e + "," + k;
		}
	}
}
