package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02467_G5_용액 {
	static int min, l, r;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		l = r = 0;
		min = Integer.MAX_VALUE;
		int left = 0;
		int right = arr.length-1;
		
		while(left!=right) {
			int now = arr[left]+arr[right];
			if(now < 0) {
				if(Math.abs(now)<Math.abs(min)) {
					l = left;
					r = right;
					min = now;
				}
				left++;
			} else {
				if(Math.abs(now)<Math.abs(min)) {
					l = left;
					r = right;
					min = now;
				}
				right--;
			}
		}
		
		System.out.println(arr[l]+" "+arr[r]);
	}
}
