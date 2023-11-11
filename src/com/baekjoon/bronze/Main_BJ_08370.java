package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_08370_B5_Plane {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int a1 = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());

		System.out.println(a*a1 + b*b1);
	}
}
