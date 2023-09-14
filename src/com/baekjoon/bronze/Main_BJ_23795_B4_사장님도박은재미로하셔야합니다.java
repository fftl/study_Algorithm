package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_23795_B4_사장님도박은재미로하셔야합니다 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n<0) break;
			res+=n;
		}

		System.out.println(res);
	}
}
