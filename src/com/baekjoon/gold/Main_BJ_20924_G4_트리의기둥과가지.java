package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_20924_G4_트리의기둥과가지 {
	static int N, R;
	static int giga;
	static ArrayList<ArrayList<Node>> arr;
	
	static class Node{
		int e, k;
		public Node(int e, int k) {
			this.e = e;
			this.k = k;
		}
		
		public String toString() {
			return e+","+k;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		for (int i = 0; i <= N; i++) arr.add(new ArrayList<>());
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			arr.get(s).add(new Node(e,k));
		}
	}
	
	static void findGiga() {
		if(arr.get(R).size() == 0) {
			giga = R;
			return;
		}
		
	}
	
	static void bfs() {
		
	}
}
