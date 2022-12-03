package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01152_B2_단어의개수 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		if(str=="") {
			System.out.println(0);
			return;
		}
		
		String[] strs = str.split(" ");
		System.out.println(strs.length);
	}
}
