package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_04344_B1_평균은넘겠지 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		for(int i=0; i<tc; i++){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			double[] arr = new double[n];
			double sum = 0;
			for(int j=0; j<n; j++) {
				arr[j] = Double.parseDouble(st.nextToken());
				sum+=arr[j];
			}
			double avg = sum/n;
			double cnt = 0;
			for (int j = 0; j < n; j++) {
				if(arr[j]>avg) cnt++;
			}
			double result = (cnt/n)*100;
			System.out.println(Double.);
		}
	}
}
