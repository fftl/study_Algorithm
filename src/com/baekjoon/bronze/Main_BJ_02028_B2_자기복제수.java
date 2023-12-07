package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02028_B2_자기복제수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			int num = now*now;

			String a = Integer.toString(now);
			String b = Integer.toString(num);

			boolean check = true;
			for (int j = 0; j < a.length(); j++) {
				if(a.charAt(a.length()-1-j) != b.charAt(b.length()-1-j)) check = false;
			}

			if(check) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
