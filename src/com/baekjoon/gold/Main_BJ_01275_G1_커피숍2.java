package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_01275_G1_커피숍2 {
	static int N, Q;
	static long[] arr;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		SegmentTree tree = new SegmentTree(N);
		tree.init(arr, 1, 1, N);
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int start = Math.min(a, b);
			int end = Math.max(a, b);
			
			int t = Integer.parseInt(st.nextToken());
			long val = Long.parseLong(st.nextToken());
			long diff = val-arr[t];
		
			sb.append(tree.sum(1, 1, N, start, end)+"\n");
			tree.update(1, 1, N, t, diff);
			arr[t] = val;
		}
		
		System.out.println(sb.toString().trim());
	}
	
	static class SegmentTree{
		long tree[];
		int treeSize;
		
		@Override
		public String toString() {
			return "SegmentTree [tree=" + Arrays.toString(tree) + ", treeSize=" + treeSize + "]";
		}

		public SegmentTree(int arrSize) {
			//트리 높이 구하기
			int h = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
			
			//높이를 이용한 배열 사이즈 구하기
			this.treeSize = (int) Math.pow(2, h+1);
			
			//배열 생성
			tree = new long[treeSize];
		}
		
		//arr = 원소배열, node = 현재노드, start = 현재구간 배열 시작, start = 현재구간 배열 끝
		public long init(long[] arr, int node, int start, int end) {
			
			//배열의 시작과 끝이 같다면 leaf 노드이므로
			//원소 배열 값 그대로 담기
			if(start == end) {
				return tree[node] = arr[start];
			}
			
			//leaf노드가 아니면, 자식 노드 합 담기
			return tree[node] 
					= init(arr, node*2, start, (start+end)/2) 
					+ init(arr, node*2+1, (start+end)/2+1, end);
		}
		
		// node: 현재노드 idx, start: 배열의 시작, end: 배열의 끝
		// idx: 변경된 데이터의 idx, diff: 원래 데이터 값과 변경 데이터 값의 차이
		public void update(int node, int start, int end, int idx, long diff) {
			//만약 변경할 index 값이 범위 바깥이면 확인 불필요
			if(idx < start || end < idx) return;
			
			//차를 저장
			tree[node] += diff;
			
			//리프노드가 아니면 아래 자식들도 확인
			if(start != end) {
				update(node*2, start, (start+end)/2, idx, diff);
				update(node*2+1, (start+end)/2+1, end, idx, diff);
			}
		}
		
		public long sum (int node, int start, int end, int left, int right) {
			if(left>end || right<start) {
				return 0;
			}
			
			if(left <= start && end <= right) {
				return tree[node];
			}
			
			long val1 = sum(node*2, start, (start+end)/2, left, right);
			long val2 = sum(node*2+1, (start+end)/2+1, end, left, right);
			return val1+val2;
		}
	}
}
