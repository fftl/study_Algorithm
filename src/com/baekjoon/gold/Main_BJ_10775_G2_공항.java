package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_10775_G2_공항 {

	static int[] parents;
	static boolean[] visited;
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if(aroot==broot) return false;
		parents[broot] = aroot;
		return true;
	}	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i; 
		}
		
		int cnt =0;
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(!visited[parents[n]]) {
				visited[parents[n]] = true;
				if(parents[n] == 0) break; 
				
				if(union(parents[n]-1, parents[n])) {
					System.out.println("cntup!");
					cnt++;
				};
			} else {
				break;
			}
		}
		
		System.out.println("answer : " + cnt);
	}
}


