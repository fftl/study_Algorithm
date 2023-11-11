package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11023_B3_더하기3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 0;
		while (st.hasMoreTokens()){
			res += Integer.parseInt(st.nextToken());
		}

		System.out.println(res);
	}
}
