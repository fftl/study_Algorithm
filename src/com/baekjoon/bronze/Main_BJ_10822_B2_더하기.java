package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10822_B2_더하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(",");

		int res = 0;
		for (String s : strs){
			res += Integer.parseInt(s);
		}

		System.out.println(res);
	}
}
