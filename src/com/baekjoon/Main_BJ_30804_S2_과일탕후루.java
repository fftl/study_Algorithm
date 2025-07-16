package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_30804_S2_과일탕후루 {
	public static void main(String[] args) throws Exception{
		int result = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] nums = new int[n];
		HashSet<Integer> set = new HashSet<>();

		for(int i=0; i<n; i++){
			int now = Integer.parseInt(st.nextToken());
			set.add(now);
			nums[i] = now;
		}

		if(set.size()==1){
			int cnt = 0;
			for(int num : set){
				for(int k=0; k<n; k++){
					if(nums[k]==num){
						cnt++;
						result = Math.max(cnt, result);
					} else {
						cnt=0;
					}
				}
			}

		} else {
			int cnt = 0;
			for(int i=1; i<9; i++){
				for(int j=i+1; j<=9; j++){
					if(set.contains(i) && set.contains(j)){
						for(int k=0; k<n; k++){
							if(nums[k]==i || nums[k]==j){
								cnt++;
								result = Math.max(cnt, result);
							} else {
								cnt=0;
							}
						}
						cnt = 0;
					}
				}
			}
		}

		System.out.println(result);
	}
}
