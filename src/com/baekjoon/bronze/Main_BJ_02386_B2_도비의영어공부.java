package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02386_B2_도비의영어공부 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.length() == 1 && str.equals("#")) {
				break;
			} else {
				String[] strs = str.split(" ");
				char now = strs[0].charAt(0);
				int cnt = 0;
				for (int i = 1; i < strs.length; i++) {
					String encode = strs[i].toLowerCase();
					for (int j = 0; j < encode.length(); j++) {
						if(encode.charAt(j) == now) cnt++;
					}
				}
				sb.append(now + " " + cnt + "\n");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
