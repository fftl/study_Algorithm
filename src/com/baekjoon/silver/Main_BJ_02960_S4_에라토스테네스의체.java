package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02960_S4_에라토스테네스의체 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] check = new boolean[N+1];
		check[0] = true;
		check[1] = true;

		int cnt = 0;
		for (int i = 2; i < N+1; i++) {
			if(!check[i]){
				for (int j = i; j < N+1; j+=i) {
					if(check[j]) continue;
					cnt++;
					if(cnt==K){
						System.out.println(j);
						return;
					}
					check[j] = true;
				}
			}
		}
	}
}
