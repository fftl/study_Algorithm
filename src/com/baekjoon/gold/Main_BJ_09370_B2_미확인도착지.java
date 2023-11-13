package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_09370_B2_미확인도착지 {
	static int n, m, t;
	static int s, g, h;
	static HashSet<Integer> end;

	static class Node{
		int s, k;
		String root;

		public Node(int s, int k, String root) {
			this.s = s;
			this.k = k;
			this.root = root;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Node{");
			sb.append("s=").append(s);
			sb.append(", k=").append(k);
			sb.append(", root='").append(root).append('\'');
			sb.append('}');
			return sb.toString();
		}
	}

	//g-h를 지나는
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			end = new HashSet<>();
			ArrayList<ArrayList<int[]>> list = new ArrayList<>();

			for (int j = 0; j <= n; j++) {
				list.add(new ArrayList<>());
			}

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int nowS = Integer.parseInt(st.nextToken());
				int nowE = Integer.parseInt(st.nextToken());
				int nowK = Integer.parseInt(st.nextToken());

				//양방향이므로 이렇게 양쪽에 추가해주었습니다
				list.get(nowS).add(new int[]{nowE, nowK});
				list.get(nowE).add(new int[]{nowS, nowK});
			}

			for (int j = 0; j < t; j++) {
				int target = Integer.parseInt(br.readLine());
				end.add(target);
			}

			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.k-o2.k;
				}
			});

			boolean[] visited = new boolean[n+1];
			visited[s] = true;
			int[] dist = new int[n+1];
			dist[s] = 0;

			pq.add(new Node(s, 0, ""));
			ArrayList<Integer> result = new ArrayList<>();

			while (!pq.isEmpty()){
				Node now = pq.poll();

				if(end.contains(now.s)){
					System.out.println(now);
					if(now.root.contains(g+"/"+h) || now.root.contains(h+"/"+g)){
						result.add(now.s);
					}
				}

				for (int[] nxt : list.get(now.s)) {

					if(!visited[nxt[0]]){
						pq.add(new Node(nxt[0], nxt[1], now.root+"/"+nxt[0]));
						dist[nxt[0]] = now.k+nxt[1];
						visited[nxt[0]] = true;
					}
				}
			}

			Collections.sort(result);
			for (int j = 0; j < result.size(); j++) {
				if(j==0){
					sb.append(result.get(j));
				} else if(j==result.size()-1){
					sb.append(" "+result.get(j)+"\n");
				} else {
					sb.append(" "+result.get(j));
				}
			}
		}

		System.out.println(sb.toString().trim());
	}
}
