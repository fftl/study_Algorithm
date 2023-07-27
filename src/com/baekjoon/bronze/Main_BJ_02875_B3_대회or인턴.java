package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02875_B3_대회or인턴 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		while(K>0) {
			if(N>M*2) {
				N--;
				K--;
			} else {
				M--;
				K--;
			}
		}
		
		int answer = 0;
		while(N>=2 && M>=1) {
			N-=2;
			M-=1;
			answer++;
		}
		
		System.out.println(answer);
		
	}
}
