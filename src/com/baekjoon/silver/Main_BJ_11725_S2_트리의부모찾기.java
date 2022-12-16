package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11725_S2_트리의부모찾기 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> node = new ArrayList<>();
		
		for (int i = 0; i <= t; i++) node.add(new ArrayList<>());
		
		for (int i = 0; i < t-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node.get(a).add(b);
			node.get(b).add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		q.add(1);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int parent = q.poll(); //부모가 될 노드!
				for (int next : node.get(parent)) {
					if(map.containsKey(next)) continue;
					
					map.put(next, parent);
					q.add(next);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= t; i++) {
			sb.append(map.get(i)+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
