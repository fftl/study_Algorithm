package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02851_B1_슈퍼마리오 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res = 0;

		for (int i = 0; i < 10; i++) {
			int now = Integer.parseInt(br.readLine());
			int next = now + res;
			if(Math.abs(100-next) < Math.abs(100-res) || Math.abs(100-next) == Math.abs(100-res)){
				res = next;
			} else {
				break;
			}
		}
		System.out.println(res);
	}
}
