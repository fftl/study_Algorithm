package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10833_B3_사과 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int res = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int apple = Integer.parseInt(st.nextToken());
			
			if(p>apple) {
				res += apple;
			} else {
				res += apple%p;
			}
		}
		
		System.out.println(res);
	}
}
