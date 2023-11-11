package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_02512_S2_예산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum += num[i];
		}

		Arrays.sort(num);

		int all = Integer.parseInt(br.readLine());

		if(sum>=all){
			System.out.println(num[num.length-1]);
		} else {
			int left = 0;
			int right = num[num.length-1];
			int mid = (left+right)/2;

			while(left<right){
				mid = (left+right)/2;


			}
		}
	}

//	static boolean check(){
//		for
//	}
}
