package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01260_S2_DFS와BFS {
	static int N, M, V, end;
	static boolean[] visited;
	static int[] result;
	static ArrayList<ArrayList<Integer>> arr;

	static void dfs(int cnt, int v) {
		if (cnt == N) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.get(v).size(); i++) {
			int z = arr.get(v).get(i);
			if (!visited[z]) {
				visited[z] = true;
				result[cnt] = z;
				dfs(cnt + 1, z);
				visited[z] = false;
			}
		}
	}

	static void bfs(int cnt, int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		System.out.println(q.toString());
		while (!q.isEmpty()) {
			System.out.println(q.toString());
			int n = q.poll();
			for (int i = 0; i < arr.get(n).size(); i++) {
				int z = arr.get(n).get(i);
				if (!visited[z]) {
					q.add(z);
					result[cnt] = z;
					cnt++;
				}
			}
			
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		result = new int[N];

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
		
		System.out.println(arr.toString());

		visited = new boolean[N + 1];
		visited[V] = true;
		result = new int[N+1];
		result[0] = V;
		end = 0;
//		dfs(1, V);

		visited = new boolean[N + 1];
		visited[V] = true;
		result = new int[N+1];
		result[0] = V;
		bfs(1, V);

	}

}
