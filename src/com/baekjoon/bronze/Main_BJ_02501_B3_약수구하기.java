package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02501_B3_약수구하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		
		for (int i = 1; i <= a; i++) {
			//약수가 된다!
			if(a%i==0) {
				if(cnt==b) {
					System.out.println(i);
					return;
				} else {
					cnt++;
				}
			}
		}
		
		System.out.println(0);
	}
}
