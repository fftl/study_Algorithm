package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_12865_G5_평범한배낭 {
	
	static class Node{
		int w, v;

		public Node(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Node [w=" + w + ", v=" + v + "]";
		}
		
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //물건의 수
		int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
		
		Node[] data = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int nowW = Integer.parseInt(st.nextToken());
			int nowK = Integer.parseInt(st.nextToken());
			data[i] = new Node(nowW, nowK);
		}
		
		Arrays.sort(data, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.w-o2.w;
			}
		});
		
		int[][] dp = new int[N][K+1];
		for (int i = 0; i < N; i++) {
			Node now = data[i];
			for (int j = 0; j < K+1; j++) {
				if(i==0) {
					if(j>=now.w) {
						dp[i][j] = now.v;
					}
				} else {
					if(j>=now.w) {
						dp[i][j] = Math.max(Math.max(now.v, dp[i-1][j-now.w]+now.v), dp[i-1][j]);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[N-1][K]);
	}
}
