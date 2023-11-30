package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02702_B2_초6수학 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for(int j=Math.max(a, b); j<=a*b; j++){
				if(j%a==0 && j%b==0){
					sb.append(j+" ");
					break;
				}
			}

			for (int j =Math.min(a, b); j >= 1; j--) {
				if(a%j==0 && b%j==0){
					sb.append(j+"\n");
					break;
				}
			}
		}

		System.out.println(sb.toString().trim());
	}
}
