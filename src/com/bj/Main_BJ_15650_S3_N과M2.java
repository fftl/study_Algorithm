package com.bj;

import java.util.Scanner;

public class Main_BJ_15650_S3_N과M2 {
	static int n, m;
	static int[] numbers, results;
	static StringBuilder sb;
	
	static void comb(int start, int cnt) {
		if(cnt == m) {
			for(int i=0; i<m; i++) {
				sb.append(results[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<n; i++) {
			results[cnt] = numbers[i];
			comb(i+1, cnt+1);
		}
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		
		numbers = new int[n];
		
		for (int i = 1; i <= numbers.length; i++) {
			numbers[i-1] = i;
		}
		
		results = new int[m];
		
		comb(0, 0);
		System.out.println(sb.toString().trim());
		sc.close();
	}

}
