package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_13023_G5_ABCDE_2 {
	
	static int max;
	static int[] visited;
	
	static void dfs(int idx, ArrayList<ArrayList<Integer>> arr,  int cnt) {
		visited[idx]++;
		if(cnt > 5) return;
		for(int i=0; i<arr.get(idx).size(); i++) {
			dfs(arr.get(idx).get(i), arr, cnt+1);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		max = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr.get(a).add(b);
		}
		System.out.println(arr.toString());
		
		for(int i=0; i<N; i++) {
			visited = new int[N];
			dfs(i, arr,  1);
			System.out.println(Arrays.toString(visited));
			int sum = 0;
			for (int j = 0; j < visited.length; j++) {
				sum += visited[j];
			}
			max = Math.max(sum, max);
		}
		
		System.out.println("13213");
		System.out.println(max);
		System.out.println("12312");
		
		if (max >= 5) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
