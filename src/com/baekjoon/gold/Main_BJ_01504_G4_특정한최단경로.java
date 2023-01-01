package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01504_G4_특정한최단경로 {
	
	static int N, E, result;
	static final int INF = 100000000;
	static ArrayList<ArrayList<Node>> nodes;

	static void dkstra(int a, int b) {
		
		int[] adist = new int[N + 1];
		int[] bdist = new int[N + 1];
		int[] ndist = new int[N + 1];
		Arrays.fill(adist, INF);
		Arrays.fill(bdist, INF);
		Arrays.fill(ndist, INF);

		//우선순위 큐로 가중치가 작은 순으로 정렬해줍니다.
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.k, o2.k);
			}
		});
		
		adist[1] = 0;

		//1->a로 가능 최단경로를 찾습니다.
		pq.add(new Node(1, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (adist[now.e] < now.k)
				continue;

			for (int i = 0; i < nodes.get(now.e).size(); i++) {
				Node next = nodes.get(now.e).get(i);
				if (adist[next.e] > next.k + now.k) {
					adist[next.e] = next.k + now.k;
					pq.add(new Node(next.e, adist[next.e]));
				}
			}
		}
		
		//만약 1->a로 가는 경로가 없었다면? 이 경로는 없는 경로이기에 바로 종료합니다.
		if (adist[a] == INF)
			return;

		bdist[a] = 0;
		
		//a->b로 가는 최단 경로를 찾습니다.
		pq.add(new Node(a, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (bdist[now.e] < now.k)
				continue;

			for (int i = 0; i < nodes.get(now.e).size(); i++) {
				Node next = nodes.get(now.e).get(i);
				if (bdist[next.e] > next.k + now.k) {
					bdist[next.e] = next.k + now.k;
					pq.add(new Node(next.e, bdist[next.e]));
				}
			}
		}

		//만약 a->b로 가는 경로가 없었다면? 바로 종료합니다.
		if (bdist[b] == INF)
			return;
		
		ndist[b] = 0;
		
		//b에서 N으로 가는 최단 경로를 찾습니다.
		pq.add(new Node(b, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (ndist[now.e] < now.k)
				continue;

			for (int i = 0; i < nodes.get(now.e).size(); i++) {
				Node next = nodes.get(now.e).get(i);
				if (ndist[next.e] > next.k + now.k) {
					ndist[next.e] = next.k + now.k;
					pq.add(new Node(next.e, ndist[next.e]));
				}
			}
		}
		
		//N까지 도착을 할 수 있었다면 1->a, a->b, b->N까지의 각각의 가중치를 더한 값을 result에 넣어줍니다.
		if (ndist[N] != INF)
			result = Math.min(result, adist[a] + bdist[b] + ndist[N]);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		result = INF;

		nodes = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			nodes.add(new ArrayList<>());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			nodes.get(s).add(new Node(e, k));
			nodes.get(e).add(new Node(s, k));
		}

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		dkstra(a, b); //1-a-b-n
		dkstra(b, a); //1-b-a-n 각각 확인해줍니다.

		//위의 두 식을 진행하며 result가 갱신된적이 없다면 갈 수 있는 경로가 없다는것 -1 출력
		//갱신이 되었다면 result를 출력합니다.
		if (result == INF)
			System.out.println(-1);
		else
			System.out.println(result);
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
