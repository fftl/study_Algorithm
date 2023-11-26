package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_20924_G4_트리의기둥과가지 {

	static int N, R, giga, gigaLen, maxLen;
	static ArrayList<ArrayList<Node>> arr;

	public static class Sum{
		int now, sum;

		public Sum(int now, int sum) {
			this.now = now;
			this.sum = sum;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Sum{");
			sb.append("now=").append(now);
			sb.append(", sum=").append(sum);
			sb.append('}');
			return sb.toString();
		}
	}

	public static class Node{
		int e, k;

		public Node(int e, int k) {
			this.e = e;
			this.k = k;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Node{");
			sb.append("e=").append(e);
			sb.append(", k=").append(k);
			sb.append('}');
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		if(N==1){
			System.out.println(0+" "+0);
			return;
		}

		arr = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			arr.get(Math.min(s, e)).add(new Node(Math.max(s, e), k));
		}

		findGiga();
		findFar();
		System.out.println(gigaLen+" "+maxLen);
	}

	static void findFar(){
		Queue<Sum> q = new LinkedList<>();
		q.add(new Sum(giga, 0));

		while(!q.isEmpty()){
			Sum now = q.poll();
			maxLen = Math.max(maxLen, now.sum);

			for(Node n : arr.get(now.now)){
				q.add(new Sum(n.e, n.k+now.sum));
			}
		}
	}

	static void findGiga(){
		if(arr.get(R).size()>1){
			giga = R;
			gigaLen = 0;
		} else {
			Node root = arr.get(R).get(0);

			gigaLen += root.k;

			Queue<Node> q = new LinkedList<>();
			q.add(root);
			while(true){
				Node now = q.poll();

				if(arr.get(now.e).size()==1){
					q.add(arr.get(now.e).get(0));
					gigaLen += arr.get(now.e).get(0).k;
				} else {
					giga = now.e;
					break;
				}
			}
		}
	}


}
