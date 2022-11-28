package com.bj.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_03111_P4_검열 {

	static String a, t;
	static int size;
	
	static void del(int s) {
		String a = t.substring(0, s);
		String b = t.substring(s+size, t.length());
		t = a+b;
	} 
	
	static int find(boolean key) {
		if(key) {
			for(int i=0; i<t.length(); i++) {
				if(t.charAt(i) == a.charAt(0)) {
					String now = t.substring(i, i+size);
					if(now.equals(a)) return i;
				}
			}
		} else {
			for(int i=t.length()-size; i>=0; i--) {
				if(t.charAt(i) == a.charAt(0)) {
					String now = t.substring(i, i+size);
					if(now.equals(a)) return i;
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		a = sc.next();
		t = sc.next();
		size = a.length();
		while(true) {
			//1
			if(!t.contains(a)) break;
			
			//2
			del(find(true));
			
			//3
			if(!t.contains(a)) break;
			
			//4
			del(find(false));
			
		}
		
		System.out.println(t);
		sc.close();
	}
}
