package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_BJ_01005_G3_ACMCraft {
	static int N, K;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int[] times = new int[N+1];
			int[] cnts = new int[N+1];
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			for (int i = 0; i <= N; i++) list.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				times[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				cnts[b]++;
				list.get(a).add(b);
			}
			
			int target = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i < cnts.length; i++) {
				if(cnts[i] == 0) q.add(i);
			}
			
			if(cnts[target] == 0) {
				System.out.println(times[target]);
				continue;
			}
			
			int res = 0;
			while(!q.isEmpty()) {
				int now = q.poll();
				
			}
			
		}
	}
}
