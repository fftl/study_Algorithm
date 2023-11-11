package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_14215_B3_세막대 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[] {a, b, c};
		Arrays.sort(arr);
		
		int max = arr[0]+arr[1];
		int minus = 0;
		
		boolean in = false;
		if(max<=arr[2]) {
			in = true;
			minus = (arr[2] - max);
		}
		
		if(in) System.out.println(a+b+c-minus-1);
		else System.out.println(a+b+c);
		
	}
}
