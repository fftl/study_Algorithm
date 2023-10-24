package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_06810_B4_ISBN {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		num += Integer.parseInt(br.readLine())*1;
		num += Integer.parseInt(br.readLine())*3;
		num += Integer.parseInt(br.readLine())*1;
		System.out.println("The 1-3-sum is "+(91+num));
	}
}
