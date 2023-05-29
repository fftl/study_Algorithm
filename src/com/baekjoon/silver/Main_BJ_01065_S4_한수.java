package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_01065_S4_한수 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if(i<=9) {
				cnt++;
				continue;
			} 
			
			String str = Integer.toString(i);
			int cha = -1;
			boolean check = true;
			for(int j=1; j<str.length(); j++) {
				int now = str.charAt(j)-'0';
				int before = str.charAt(j-1)-'0';
				
				if(j==1) cha = before-now;
				else {
					if(cha != (before-now)) check = false; 
				}
			}
			
			if(check) cnt++;
		}
		
		System.out.println(cnt);
	}
}
