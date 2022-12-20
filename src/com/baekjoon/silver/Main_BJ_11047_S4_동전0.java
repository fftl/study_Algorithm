package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11047_S4_동전0 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		int[] money = new int[n];
		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		for (int i = n-1; 0 <= i; i--) {
			if(t<money[i]) continue;
			else {
				result += t/money[i];
				t = t%money[i];
			}
		}
		
		System.out.println(result);
	}
}
