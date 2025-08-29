package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_02470_G5_두용액 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		if(num[0]>=0){
			System.out.println(num[0]+" "+num[1]);
		} else if(num[num.length-1]<0){
			System.out.println(num[num.length-2]+" "+num[num.length-1]);
		}

		int result = Integer.MAX_VALUE;

		int left = 0;
		int right = n-1;

		int[] answer = new int[2];
		while(left<right) {
			int now = num[left] + num[right];
			if (now == 0) {
				answer[0] = num[left];
				answer[1] = num[right];
				break;
			}
		}

		System.out.println(num[left]+","+num[right]);
	}
}
