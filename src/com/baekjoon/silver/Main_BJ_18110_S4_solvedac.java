package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_18110_S4_solvedac {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println(0);
			return;
		}
		
		double d = n;
		double[] num = new double[n];
		
		for (int i = 0; i < num.length; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		
		double cut = d * 3 / 20.0;
		int se = (int)Math.round(cut);
		
		Arrays.sort(num);
		
		double sum = 0;
		double cnt = 0;
		for (int i = se; i < num.length-se; i++) {
			sum += num[i];
			cnt++;
		}
		
		System.out.println(Math.round(sum/cnt));
	}
}
