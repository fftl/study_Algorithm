package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01546_B1_평균 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[t];

		int max = 0;
		for (int i = 0; i < t; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
			max = Math.max(now, max);
		}
		
		double result = 0;
		for (int i = 0; i < t; i++) {
			double now = (double)arr[i]*100 / max;
			result += (double) arr[i]*100 / max;
		}
		
		System.out.println(result/t);
	}
}
