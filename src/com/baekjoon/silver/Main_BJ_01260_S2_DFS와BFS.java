package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_01260_S2_DFS와BFS {
	static int N, M, V, end;
	static boolean[] visited;
	static int[] result;
	static ArrayList<ArrayList<Integer>> arr;

	static void dfs(int cnt, int v) {
		System.out.print(v+" ");
		for (int i = 0; i < arr.get(v).size(); i++) {
			int z = arr.get(v).get(i);
			if (!visited[z]) {
				visited[z] = true;
				dfs(cnt + 1, z);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		end = 0;

		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}

		for (int i = 0; i < arr.size(); i++) {
			Collections.sort(arr.get(i));
		}

		// dfs run
		visited = new boolean[N + 1];
		visited[V] = true;
		
		dfs(0, V);
		System.out.println();
		
		// bfs run
		visited = new boolean[N + 1];
		visited[V] = true;

		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		run: while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				System.out.print(now + " ");
				cnt++;
				if (cnt == N)
					break run;

				for (int j = 0; j < arr.get(now).size(); j++) {
					if (visited[arr.get(now).get(j)])
						continue;
					q.add(arr.get(now).get(j));
					visited[arr.get(now).get(j)] = true;
				}
			}
		}
	}
}
