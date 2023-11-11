package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02902_G2_KMP는왜KMP일까 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String res = "";
		for (int i = 0; i < str.length(); i++) {
			if(65<=str.charAt(i) && 90>=str.charAt(i)){
				res +=str.charAt(i);
			}
		}

		System.out.println(res);
	}
}
