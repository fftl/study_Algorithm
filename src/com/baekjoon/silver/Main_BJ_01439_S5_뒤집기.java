package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01439_S5_뒤집기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int[] cnt = new int[2];

		char now = str.charAt(0);
		cnt[now-'0']++;
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i)==now){
				continue;
			} else {
				now = str.charAt(i);
				cnt[now-'0']++;
			}
		}

		System.out.println(Math.min(cnt[0], cnt[1]));
	}
}
