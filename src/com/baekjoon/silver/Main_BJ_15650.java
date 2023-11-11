package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_15650_S3_N과M2 {
	static int n, m;
	static int[] numbers, results;
	static StringBuilder sb;
	
	static void comb(int start, int cnt) {
		//목표개수에 도달하면 중지
		if(cnt == m) {
			for(int i=0; i<m; i++) {
				sb.append(results[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		//start와 cnt값을 이용해 반복해줍니다.
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
		
		//1부터 n까지의 수를 담아줍니다.
		for (int i = 1; i <= numbers.length; i++) {
			numbers[i-1] = i;
		}
		
		//출력값을 담아줄 results 배열입니다.
		results = new int[m];
		
		comb(0, 0);
		System.out.println(sb.toString().trim());
		sc.close();
	}

}
