package com.baekjoon.platinum;

import java.util.Scanner;

public class Main_BJ_03111_P4_검열_a {

	static String a;
	static StringBuilder sb;
	static int size;
	
	static void del(int s) {
		sb.delete(s, size+s);
	} 
	
	static int find(boolean key) {
		if(key) {
			for(int i=0; i<sb.toString().length(); i++) {
				if(sb.charAt(i) == a.charAt(0)) {
					String now = sb.substring(i, i+size);
					if(now.equals(a)) return i;
				}
			}
		} else {
			for(int i=sb.toString().length()-size; i>=0; i--) {
				if(sb.charAt(i) == a.charAt(0)) {
					String now = sb.substring(i, i+size);
					if(now.equals(a)) return i;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		a = sc.next();
		size = a.length();
		
		sb.append(sc.next());
		
		while(true) {
			//1
			if(sb.indexOf(a) == -1) break;
			
			//2
			del(find(true));
			
			//3
			if(sb.indexOf(a) == -1) break;
			
			//4
			del(find(false));
		}
		
		System.out.println(sb.toString());
		sc.close();
	}
}
