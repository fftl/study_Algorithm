package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_10809_B5_알파벳찾기 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] cnt = new int[26];
		for (int i = 0; i < cnt.length; i++) {
			cnt[i] = -1;
		}

		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			int idx = now - 'a';
			if (cnt[idx] == -1) {
				cnt[idx] = i;
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < cnt.length; j++) {
			sb.append(cnt[j]+" ");
		}
		
		System.out.println(sb.toString().trim());
		sc.close();
	}
}
