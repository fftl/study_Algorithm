package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_15649_S3_N과M1 {
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[] nums = new boolean[N+1];
		sb = new StringBuilder();
		
		dfs(0, nums, "");
		
		System.out.println(sb.toString().trim());
	}
	
	static void dfs(int cnt, boolean[] nums, String now) {
		if(cnt == M) {
			sb.append(now+"\n");
			return;
		}
		
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]) continue;
			nums[i] = true;
			if(cnt == 0) {
				dfs(cnt+1, nums, now+i);
			} else {
				dfs(cnt+1, nums, now+" "+i);
			}
			nums[i] = false;
		}
	}
}
