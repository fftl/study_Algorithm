package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02935_B3_소음 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		char cmd = br.readLine().charAt(0);
		String b = br.readLine();

		int aLen = a.length();
		int bLen = b.length();

		StringBuilder sb = new StringBuilder();
		if(cmd=='+') {
			if (aLen == bLen) {
				for (int i = 0; i < aLen; i++) {
					if (i == 0) {
						sb.append(2);
					} else {
						sb.append(0);
					}
				}
				System.out.println(sb.toString());
				return;
			} else {
				for (int i = 0; i < Math.max(aLen, bLen); i++) {
					if (i == 0 || i == (Math.max(aLen, bLen) - Math.min(aLen, bLen))) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
				System.out.println(sb.toString());
				return;
			}
		} else {
			if(aLen+bLen-2 <= 0){
				System.out.println(1);
			} else {
				sb.append(1);
				for (int i = 0; i < aLen+bLen-2; i++) {
					sb.append(0);
				}

				System.out.println(sb.toString());
				return;
			}
		}
	}
}
