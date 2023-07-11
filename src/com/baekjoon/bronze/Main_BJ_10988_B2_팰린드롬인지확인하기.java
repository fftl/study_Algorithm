package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_10988_B2_팰린드롬인지확인하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder(str);
		if(sb.toString().equals(sb.reverse().toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
