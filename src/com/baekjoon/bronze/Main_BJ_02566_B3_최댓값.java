package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02566_B3_최댓값 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int max = 0;	
		int y = -1;
		int x = -1;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now>=max) {
					max = now;
					y = i+1;
					x = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(y+" "+x);
	}
}
