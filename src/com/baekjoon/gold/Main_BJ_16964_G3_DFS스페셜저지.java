package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_16964_G3_DFS스페셜저지 {
	static int N;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;
	static Queue<Integer> result;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		arr = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr.get(s).add(e);
			arr.get(e).add(s);
		}

		st = new StringTokenizer(br.readLine());

		result = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			result.add(Integer.parseInt(st.nextToken()));
		}

		visited = new boolean[N+1];

		if(dfs(1, 0)){
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	//어떻게 모든 경우에 dfs를 구할까..
	static boolean dfs(int now, int parent) {
		if(visited[now]) return true;

		int size = arr.get(now).size();
		visited[now] = true;

		HashSet<Integer> set = new HashSet<>();

		for(int n : arr.get(now)){
			if(n != parent) set.add(n);
		}

		while(!set.isEmpty()){
			int temp = result.poll();
			if(set.contains(temp)) {
				set.remove(temp);
				if (!dfs(temp, now)) return false;
			} else return false;
		}
		return true;
	}
}
