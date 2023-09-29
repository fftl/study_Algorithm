package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02864_B2_5와6의차이 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();

		String a1 = "";
		String a2 = "";

		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '5' || a.charAt(i) == '6'){
				a1 += "5";
				a2 += "6";
			} else {
				a1 += a.charAt(i);
				a2 += a.charAt(i);
			}
		}

		String b1 = "";
		String b2 = "";

		for (int i = 0; i < b.length(); i++) {
			if(b.charAt(i) == '5' || b.charAt(i) == '6'){
				b1 += "5";
				b2 += "6";
			} else {
				b1 += b.charAt(i);
				b2 += b.charAt(i);
			}
		}
		System.out.println((Integer.parseInt(a1)+Integer.parseInt(b1))+" "+(Integer.parseInt(a2)+Integer.parseInt(b2)));
	}
}
