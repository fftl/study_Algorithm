package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02042_G1_구간합구하기 {
	static int N, M, K;
	static long[] nums;
	
	static class SegmentTree{
		long[] tree;
		int treeSize;
		
		//초기화 할 때 배열의 크기를 가지고 long 배열과 트리의 크기를 구해줍니다.
		public SegmentTree(int arrSize) {
			int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
			this.treeSize = (int) Math.pow(2, h+1);
			tree = new long[treeSize];
		}
		
		//재귀를 이용해 각 트리의 자식들을 합하는 방식으로 모든 단계의? 합을 구합니다.
		public long init(long[] arr, int node, int start, int end) {
			if(start == end) {
				return tree[node] = arr[start];
			}

			//현재 노드의 왼쪽아래 + 오른쪽 아래 노드의 합을 리턴.
			return tree[node] = init(arr, node*2, start, (start+end)/2) +
					init(arr, node*2+1, (start+end)/2+1, end);
		}
		
		//중간의 값이 변경되는 것을 표현합니다.
		//무슨 연산을 하던 node는 1부터 시작합니다.
		public void update(int node, int start, int end, int idx, long diff) {
			//변경될 값의 idx가 범위를 벗어날 경우 종료합니다.
			if(idx < start || end < idx) return;
			
			tree[node] += diff;
			
			if(start != end) {
				update(node*2, start, (start+end)/2, idx, diff);
				update(node*2+1, (start+end)/2+1, end, idx, diff);
			}
		}
		
		//start ~ end 의 합을 구합니다.
		public long sum(int node, int start, int end, int left, int right) {
			if(left > end || right < start) {
				return 0;
			}
			
			if(left <= start && end <= right) {
				return tree[node];
			}
			
			return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right); 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree tree = new SegmentTree(N);
		tree.init(nums, 1, 1, N);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			//수 변경하기
			if(a==1) {
				tree.update(1, 1, N, b,  c-nums[b]);
				nums[b] = c;
			} else if(a==2) {
				sb.append(tree.sum(1, 1, N, b, (int)c) + "\n");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
