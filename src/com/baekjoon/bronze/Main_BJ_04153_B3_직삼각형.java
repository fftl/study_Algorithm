package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_04153_B3_직삼각형 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];
			for (int i = 0; i < arr.length; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 0) return;
				arr[i] = n;
			}
			
			Arrays.sort(arr);
			
			if(arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2])System.out.println("right");
			else System.out.println("wrong");
			
		}
	}
}
