package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_02252_G3_줄세우기 {
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		int[] size = new int[N+1];
		
		
		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			size[b]++;
			arr.get(a).add(b);
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			if(size[i]==0) q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
//			System.out.println(q.toString());
			int now = q.poll();
			sb.append(now+" ");
			
			for (int i = 0; i < arr.get(now).size(); i++) {
				int next = arr.get(now).get(i);
				size[next]--;
				if(size[next] == 0) q.add(next);
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
