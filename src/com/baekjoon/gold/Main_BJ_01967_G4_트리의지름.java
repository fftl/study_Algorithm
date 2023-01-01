package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01967_G4_트리의지름 {
	static int N;
	static ArrayList<ArrayList<Node>> nodes;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(0);
			return;
		}

		nodes = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			nodes.add(new ArrayList<>());

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			nodes.get(s).add(new Node(e, k));
			nodes.get(e).add(new Node(s, k));
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.k, o2.k);
			}
		});

		pq.add(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (dist[now.e] < now.k)
				continue;

			for (int i = 0; i < nodes.get(now.e).size(); i++) {
				Node next = nodes.get(now.e).get(i);

				if (dist[next.e] > next.k + now.k) {
					dist[next.e] = next.k + now.k;
					pq.add(new Node(next.e, dist[next.e]));
				}
			}
		}

		int max = 0;
		int maxIdx = -1;

		for (int i = 1; i < dist.length; i++) {
			int now = dist[i];
			if (now != Integer.MAX_VALUE && max < now) {
				max = now;
				maxIdx = i;
			}
		}

		// 첫번째 최대값에서 다시 최대 거리를 구합니다 이게 진짜 최대가 됩니다!
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[maxIdx] = 0;

		pq.add(new Node(maxIdx, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (dist[now.e] < now.k)
				continue;

			for (int i = 0; i < nodes.get(now.e).size(); i++) {
				Node next = nodes.get(now.e).get(i);

				if (dist[next.e] > next.k + now.k) {
					dist[next.e] = next.k + now.k;
					pq.add(new Node(next.e, dist[next.e]));
				}
			}
		}

		max = 0;
		maxIdx = -1;

		for (int i = 1; i < dist.length; i++) {
			int now = dist[i];
			if (now != Integer.MAX_VALUE && max < now) {
				max = now;
				maxIdx = i;
			}
		}

		System.out.println(max);
	}

	static class Node {
		int e, k;

		public Node(int e, int k) {
			super();
			this.e = e;
			this.k = k;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + ", k=" + k + "]";
		}

	}
}
