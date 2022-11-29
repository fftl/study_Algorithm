package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_02475_B5_검증수 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int now = Integer.parseInt(st.nextToken());
			sum += now*now;
		}
		
		System.out.println(sum%10);
	}
}
