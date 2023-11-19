package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01977_B2_완전제곱수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[] check = new boolean[10001];

		check[1] = true;

		for (int i = 2; i <= 10000; i++) {
			if(i*i<=10000){
				check[i*i] = true;
			}
		}

		int resMin = 10000;
		int resSum = 0;

		boolean able = false;
		for (int i = N; i <= M; i++) {
			if(check[i]) {
				able = true;
				resMin = Math.min(resMin, i);
				resSum += i;
			}
		}

		if(able){
			System.out.println(resSum);
			System.out.println(resMin);
		} else {
			System.out.println(-1);
		}
	}
}
