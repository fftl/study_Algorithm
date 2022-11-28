package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01157_B1_단어공부 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		str = str.toUpperCase();
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		
		
		int max = 0;
		String maxStr = "";
		for(Character c : map.keySet()) {
			if(map.get(c)>max) {
				max = map.get(c);
				maxStr = "";
				maxStr += c;
			} else if(map.get(c) == max) {
				maxStr += c;
			}
		}
		
		if(maxStr.length() == 1) {
			System.out.println(maxStr);
		} else {
			System.out.println("?");
		}
	}
}
