package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_BJ_01076_B2_저항 {
	static HashMap<String, Long> sum, multi;
	
	public static void main(String[] args) throws Exception{
		sum = new HashMap<String, Long>();
		multi = new HashMap<String, Long>();
		
		sum.put("black", 0L);
		sum.put("brown", 1L);
		sum.put("red", 2L);
		sum.put("orange", 3L);
		sum.put("yellow", 4L);
		sum.put("green", 5L);
		sum.put("blue", 6L);
		sum.put("violet", 7L);
		sum.put("grey", 8L);
		sum.put("white", 9L);
		
		multi.put("black", 1L);
		multi.put("brown", 10L);
		multi.put("red", 100L);
		multi.put("orange", 1000L);
		multi.put("yellow", 10000L);
		multi.put("green", 100000L);
		multi.put("blue", 1000000L);
		multi.put("violet", 10000000L);
		multi.put("grey", 100000000L);
		multi.put("white", 1000000000L);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long res = 0;
		String a = br.readLine();
		res += sum.get(a)*10;
		
		String b = br.readLine();
		res += sum.get(b);
		
		String c = br.readLine();
		res *= multi.get(c);
		
		System.out.println(res);
	}
}
