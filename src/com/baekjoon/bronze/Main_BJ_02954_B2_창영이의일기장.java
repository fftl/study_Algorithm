package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_02954_B2_창영이의일기장 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.replaceAll("apa", "a");
		str = str.replaceAll("epe", "e");
		str = str.replaceAll("ipi", "i");
		str = str.replaceAll("opo", "o");
		str = str.replaceAll("upu", "u");

		System.out.println(str);
	}
}
