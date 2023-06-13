package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_BJ_02941_S5_크로아티아알파벳 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String check = "cdlnsz";
		
		HashSet<String> set = new HashSet<>();
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");
		
		int len = str.length();
		int idx = 0;
		int result = 0;
		
		while(idx<len) {
			String now = str.charAt(idx)+"";
			if(check.contains(now)) {
				if(now.equals("d")) {
					if(idx+3 <= len) {
						if(set.contains(str.substring(idx, idx+3))){
							idx+=3;
							result++;
						} else {
							idx+=1;
							result++;
						}
					}
				} else {
					if(idx+2 <= len) {
						if(set.contains(str.substring(idx, idx+2))){
							idx+=2;
							result++;
						} else {
							idx+=1;
							result++;
						}
					}
				}
				
			} else {
				idx++;
				result++;
			}
		}
		
		System.out.println(result);
	}
}
