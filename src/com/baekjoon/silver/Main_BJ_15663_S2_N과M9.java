package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_BJ_15663_S2_N과M9 {
	static int n, m;
	static int[] arr, permu;
	static boolean[] visited;
	static LinkedHashSet<String> result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		permu = new int[m];
		visited = new boolean[n];
		result = new LinkedHashSet<>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
		}
		
		Arrays.sort(arr);
		permutation(0);
		
		Iterator<String> it = result.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static void permutation(int cnt) {
		if(cnt == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < permu.length; i++) {
				sb.append(permu[i]+" ");
			}
			result.add(sb.toString().trim());
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			permu[cnt] = arr[i];
			visited[i] = true;
			permutation(cnt+1);
			visited[i] = false;
		}
	}
}
