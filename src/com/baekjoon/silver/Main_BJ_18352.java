package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_18352_S2_특정거리의도시찾기 {
	static int N, M, K, X;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr.get(s).add(e);
		}

		boolean[] visited = new boolean[N+1];
		visited[X]=true;

		Queue<Integer> q = new LinkedList<>();
		for (int n : arr.get(X)) {
			visited[n] = true;
			q.add(n);
		}

		int len = 1;

		while (!q.isEmpty()){
			if(len == K) break;

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();

				for (int n : arr.get(now)) {
					if(!visited[n]){
						visited[n] = true;
						q.add(n);
					}
				}
			}

			len++;
		}

		StringBuilder sb = new StringBuilder();
		if(q.size()==0) System.out.println(-1);
		else{
			if(len!=K) System.out.println(-1);
			else {
				ArrayList<Integer> result = new ArrayList<>();
				for (int n : q) result.add(n);

				Collections.sort(result);
				for (int n : result) sb.append(n + "\n");

				System.out.println(sb.toString().trim());
			}
		}
	}
}
