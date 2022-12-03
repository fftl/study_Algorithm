package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_15829_B2_Hashing {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		long key = 31;
		long div = 1234567891;
		long result = 0;
		long square = 1;
		
		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i)-'a'+1;	
			result += now * square % div;
			square = square * key % div;
		}
		
		//결과물 출력!
		System.out.println(result%div);
	}
}
