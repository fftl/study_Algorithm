package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_14038_B4_TournamentSelection {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int win = 0;
		for (int i = 0; i < 6; i++) {
			String str = br.readLine();
			if(str.equals("W")) win++;
		}

		if(win>=5) System.out.println(1);
		else if(win>=3) System.out.println(2);
		else if(win>=1) System.out.println(3);
		else System.out.println(-1);
	}
}
