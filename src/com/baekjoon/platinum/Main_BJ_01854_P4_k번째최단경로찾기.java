package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01854_P4_k번째최단경로찾기 {
	static int n, m, k;
	
	static class Node{
		int n, k;

		public Node(int n, int k) {
			super();
			this.n = n;
			this.k = k;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [n=");
			builder.append(n);
			builder.append(", k=");
			builder.append(k);
			builder.append("]");
			return builder.toString();
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> arr = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
		}
 	}
}
