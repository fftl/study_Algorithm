package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_05525_S1_IOIOI {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		char[] arr = br.readLine().toCharArray();
		int[] memo = new int[M];
		int ans = 0;
		
		for (int i = 1; i < M-1; i++) {
			if(arr[i] == 'O' && arr[i+1] == 'I') {
				memo[i+1] = memo[i-1] + 1;
				
				if(memo[i+1] >= N && arr[i-2 * N+1] == 'I') ans++;
			}
		}
		
		System.out.println(Arrays.toString(memo));
		System.out.println(Arrays.toString(arr));
		System.out.println(ans);
		
	}
}
