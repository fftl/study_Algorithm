package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_23825_B4_SASA모형을만들어보자 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());

		int sS = S/2;
		int sA = A/2;

		int cnt = 0;

		while(sS>0 && sA>0){
			cnt++;
			sS--;
			sA--;
		}

		System.out.println(cnt);
	}
}
