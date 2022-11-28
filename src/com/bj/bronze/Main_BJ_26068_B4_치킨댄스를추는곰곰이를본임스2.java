package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_26068_B4_치킨댄스를추는곰곰이를본임스2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			String[] strs = br.readLine().split("-");
			if(Integer.parseInt(strs[1])<=90) result++;
		}
		
		System.out.println(result);
	}
}
