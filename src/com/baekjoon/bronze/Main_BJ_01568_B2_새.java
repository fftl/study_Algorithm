package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01568_B2_새 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int second = 0;
		int num = 1;
		while(true){
			if(n==0) break;
			if(num<=n){
				n -= num;
				num++;
			} else {
				num = 1;
				n -= num;
				num++;
			}

			second++;
		}

		System.out.println(second);
	}
}
