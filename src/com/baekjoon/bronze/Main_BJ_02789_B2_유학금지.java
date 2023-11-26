package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_BJ_02789_B2_유학금지 {
	static HashSet<Character> check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars = br.readLine().toCharArray();

		check = new HashSet<>();

		check.add('C');
		check.add('A');
		check.add('M');
		check.add('B');
		check.add('R');
		check.add('I');
		check.add('D');
		check.add('G');
		check.add('E');

		StringBuilder sb = new StringBuilder();

		for (char c : chars){
			if(!check.contains(c)) sb.append(c);
		}

		System.out.println(sb.toString());

	}
}
