package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01789_S5_수들의합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());

		long now = 1;
		long sum = 0;
		int cnt = 0;

		while(true){
			if(sum==n){
				System.out.println(cnt);
				return;
			} else if(sum>n){
				System.out.println(cnt-1);
				return;
			}

			sum += now;
			now++;
			cnt++;
		}
	}
}
