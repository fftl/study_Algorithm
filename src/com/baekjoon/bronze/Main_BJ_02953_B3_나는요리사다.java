package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02953_B3_나는요리사다 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int idx = 0;
		int max = 0;
		for (int i = 1; i <= 5; i++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			
			if(sum>max) {
				idx = i;
				max = sum;
			}
		}
		
		System.out.println(idx+" "+max);
	}
}
