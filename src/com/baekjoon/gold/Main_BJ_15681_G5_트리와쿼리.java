package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_15681_G5_트리와쿼리 {
	static int N, R, Q;
	static Node node;
	static class Node{
		int parent, cnt;
		ArrayList<Node> child;

		public Node(int parent, int cnt, ArrayList<Node> child){
			this.parent = parent;
			this.cnt = cnt;
			this.child = child;
		}
	}
	static ArrayList<ArrayList<Integer>> input;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		input = new ArrayList<>();
		for(int i=0; i<N; i++) input.add(new ArrayList<>());

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			input.get(a).add(b);
			input.get(b).add(a);
		}

//		node = make(R);
//		make(R);
	}

//	static Node make(int parent){
//		if(parent == 0){
//			Node node = new Node(parent, 0, new ArrayList<>());
//
//		}
//
//
//		ArrayList<Integer> now = input.get(parent);
//		if(now.size()==1) return null;
//
//		for(int i=0;i<now.size(); i++){
//			node.child.add(new Node(parent, 0, new ArrayList<>()));
//		}
//	}
}
