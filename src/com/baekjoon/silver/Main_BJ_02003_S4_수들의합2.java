package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02003_S4_수들의합2 {
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N+1];
		st = new StringTokenizer(br.readLine());
		int res = 0;
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(nums[i] == M) res++;
		}
		
		for (int i = 2; i < nums.length; i++) {
			int sIdx = 1;
			int eIdx = i;
			int nowSum = 0;
			
			for (int j = 1; j<=i ; j++) {
				nowSum += nums[j];
			}
			
			if(nowSum == M) res++;
			
			while(eIdx<N) {
				nowSum = nowSum - nums[sIdx] + nums[++eIdx];
				if(nowSum == M) {
					res++;
				}
				sIdx++;
			}
		}
		System.out.println(res);
	}
}
