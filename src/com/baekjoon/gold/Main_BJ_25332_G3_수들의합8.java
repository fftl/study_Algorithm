package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_25332_G3_수들의합8 {
	
	static long n;
	static long[] A, B, sum;
	static HashMap<Long, Long> map;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Long.parseLong(br.readLine());
		A = new long[200001];
		B = new long[200001];
		sum = new long[200001];
		map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			B[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i-1]+B[i]-A[i];
		}
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(sum));
		
		long result = 0;
		for (int i = 1; i <= n; i++) {
			if(sum[i] == 0) result++;
			if(!map.containsKey(sum[i])) {
				map.put(sum[i], (long)1);
				result++;
			} else {
				result += map.get(sum[i]);
				map.put(sum[i], map.get(sum[i])+1);
			}
		}
		
		System.out.println(result);
	}
}
