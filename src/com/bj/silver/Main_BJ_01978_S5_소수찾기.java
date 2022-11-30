package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01978_S5_소수찾기 {

	public static void main(String[] args) throws Exception{
		
		//1 ~ 1000의 수중에 소수를 찾아낸다!
		boolean[] check = new boolean[10001];
		check[0] = check[1] = true;
		
		for (int i = 2; i*i < 10001; i++) {
			if(!check[i]) {
				for (int j = i*i; j < 10001; j+=i) check[j] = true;
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int result = 0;
		for (int i = 0; i < t; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(!check[now]) result++;
		}
		
		System.out.println(result);
	}
}
