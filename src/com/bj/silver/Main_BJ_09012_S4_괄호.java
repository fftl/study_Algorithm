package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_09012_S4_괄호 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			int balance = 0;
			boolean check = true;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') balance++;
				else balance--;
				
				if(balance<0) {
					check = false;
					break;
				}
			}
			
			if(!check) {
				System.out.println("NO");
				continue;
			}
			
			if(balance != 0) System.out.println("NO");
			else System.out.println("YES");
			
		}
	}
}
