package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_01167_G2_트리의지름 {

	static class Node {
		int point;
		int len;

		Node(int point, int len) {
			this.point = point;
			this.len = len;
		}

		@Override
		public String toString() {
			return "[point=" + point + ", len=" + len + "]";
		}

	}

	static ArrayList<ArrayList<Node>> nodes;
	static int N, result;
	static boolean[] visited;

	static void dfs(int n, int len) {
		result = Math.max(len, result);
		ArrayList<Node> nowArr = nodes.get(n);
		for (int i = 0; i < nowArr.size(); i++) {
			Node node = nowArr.get(i);
			if (visited[node.point])continue;
			visited[node.point] = true;
			dfs(node.point, len + node.len);
			visited[node.point] = false;

		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		result = 0;

		nodes = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			nodes.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			while (true) {
				int a = Integer.parseInt(st.nextToken());
				if (a == -1)
					break;
				int b = Integer.parseInt(st.nextToken());

				nodes.get(now).add(new Node(a, b));
			}
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			dfs(i, 0);
		}

		System.out.println(result);
	}
}
