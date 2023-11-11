package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02042_G1_구간합구하기 {
	static long[] nums;
	
	public static class Seg{
		long[] nodes;
		
		public Seg(int i) {
			nodes = new long[i*4];
		}
		
		public long init(int node, int start, int end) {
			if(start==end) {
				return nodes[node] = nums[start];
			}
			
			return nodes[node] = init(node*2, start, (start+end)/2) + 
					init(node*2+1, (start+end)/2+1, end);
		}
		
		public void	 update(int node, int start, int end, int idx, long cha) {
			if(idx < start || end < idx) return;
			nodes[node] += cha;
			
			if(start != end) {				
				update(node*2, start, (start+end)/2, idx, cha);
				update(node*2+1, (start+end)/2+1, end, idx, cha);
			}
		}
		
		public long sum(int node, int start, int end, int left, int right){
			if(end < left || right < start) {
				return 0;
			}
			
			if(left<=start && end <=right) {
				return nodes[node];
			}
			
			return sum(node*2, start, (start+end)/2, left, right) + sum(node*2+1, (start+end)/2+1, end, left, right); 
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		nums = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		
		Seg seg = new Seg(N);
		seg.init(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(key == 1) {
				seg.update(1, 1, N, a, b-nums[a]);
				nums[a] = b;
			} else {
				sb.append(seg.sum(1, 1, N, a, (int)b)+"\n");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
