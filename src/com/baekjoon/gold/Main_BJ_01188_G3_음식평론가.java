package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01188_G3_음식평론가 {
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		System.out.println(M-gcd(N,M));
	}

	static int gcd(int a, int b) {
		return a%b == 0 ? b: gcd(b, a%b);
	}
}
