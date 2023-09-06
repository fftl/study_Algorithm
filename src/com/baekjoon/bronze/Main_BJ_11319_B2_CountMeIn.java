package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_11319_B2_CountMeIn {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Character> Vowels = new ArrayList<>();
		Vowels.add('A');
		Vowels.add('E');
		Vowels.add('I');
		Vowels.add('O');
		Vowels.add('U');
		Vowels.add('a');
		Vowels.add('e');
		Vowels.add('i');
		Vowels.add('o');
		Vowels.add('u');
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			int c = 0, v = 0;
			for (int j = 0; j < str.length(); j++) {
				if(Vowels.contains(str.charAt(j))) v++;
				else if(str.charAt(j) != ' ') c++;
			}
			sb.append(c+" "+v+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
