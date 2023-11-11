package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01550_B2_16진수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(Integer.parseInt(str, 16));
	}
}
