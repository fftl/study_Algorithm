package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_01389_S1_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Set<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) list.add(new HashSet<>());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited;
		int nowMin = Integer.MAX_VALUE;
		int result = -1;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			visited[i] = true;
			q.add(i);
			
			int dep = 1;
			int cnt = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				for (int j = 0; j < size; j++) {
					int w = q.poll();
					Set<Integer> now = list.get(w);
					for(int num : now) {
						if(!visited[num]) {
							visited[num] = true;
							q.add(num);
							cnt+=dep;
						}
					}
				}
				dep++;
			}
			
			if(nowMin>cnt) {
				nowMin = cnt;
				result = i;
			}
		}
		System.out.println(result);
	}
}
