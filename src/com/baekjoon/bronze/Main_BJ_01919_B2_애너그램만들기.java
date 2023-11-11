package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01919_B2_애너그램만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cnt1 = new int[26];
		int[] cnt2 = new int[26];

		String a = br.readLine();
		String b = br.readLine();

		for (int i = 0; i < a.length(); i++) {
			char now = a.charAt(i);
			cnt1[now-'a']++;
		}

		for (int i = 0; i < b.length(); i++) {
			char now = b.charAt(i);
			cnt2[now-'a']++;
		}

		int res = 0;
		for (int i = 0; i < 26; i++) {
			res += Math.abs(cnt1[i] - cnt2[i]);
		}
		System.out.println(res);
	}
}