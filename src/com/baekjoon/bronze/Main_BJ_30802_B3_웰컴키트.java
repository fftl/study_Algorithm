package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_30802_B3_웰컴키트 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] size = new int[6];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++){
			size[i] = Integer.parseInt(st.nextToken());
		}

		int T,P;
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		int shirt = 0;
		for(int i=0; i<6; i++){
			if(size[i]%T==0) shirt += size[i]/T;
			else shirt += size[i]/T +1;
		}

		System.out.println(shirt);
		System.out.println(N/P+" "+N%P);
	}
}
