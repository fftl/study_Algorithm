package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BJ_01972_S3_놀라운문자열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringBuilder sb = new StringBuilder();
		while(true){
			str = br.readLine();
			if(str.equals("*")) break;
			if(amazing(str)){
				sb.append(str+" is surprising."+"\n");
			} else {
				sb.append(str+" is NOT surprising."+"\n");
			}
		}

		System.out.println(sb.toString().trim());
	}

	static boolean amazing(String str){
		int len = str.length();

		HashSet<String> set;

		for (int i = 1; i <= len-2; i++) {
			set = new HashSet<>();
			for (int j = 0; j <= len -1 -i; j++) {
				String nextStr = str.charAt(j)+""+str.charAt(j+i);
				if(set.contains(nextStr)) {
					return false;
				}
				else {
					set.add(nextStr);
				}
			}
		}

		return true;
	}
}
