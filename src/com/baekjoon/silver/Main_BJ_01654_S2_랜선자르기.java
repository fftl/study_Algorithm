package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01654_S2_랜선자르기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int max = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			max = Math.max(max,  num);
			arr[i] =  num;
		}
		
		// 모두 0으로 변경
		long left = 1; //0 -> 1
		long right = max;
		long result = 0;
		long mid;
		
		while(left<=right) { //< -> <=
			mid = (left + right)/2;
			if(mid == 0) break;
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				cnt += arr[i]/mid;
			}
			
			if(cnt>=k) {
				left = mid+1;
				result = Math.max(result, mid);
			} else {
				right = mid-1;
			}
		}
		
		System.out.println(result);
	}
}
