package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_08958_B2_OX퀴즈 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			
			int now = 0;
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'O') {
					cnt++;
					now += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(now);
		}
	}
}
