package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_01747_S1_소수n팰린드롬 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[10000001];
		prime[1] = true;
		
		for (int i = 2; i < prime.length; i++) {
			if(!prime[i]) {
				for (int j = i+i; j < prime.length; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for (int i = n; i < prime.length; i++) {
			if(!prime[i]) {
				if(check(Integer.toString(i))) {
					System.out.println(i);
					return;
				}
			}
		}
	}
	
	static boolean check(String str) {
		Stack<Character> st = new Stack<Character>();
		if(str.length()==1) return true;
		
		//숫자가 짝수일 경우
		if(str.length()%2==0) {
			for (int i = 0; i < str.length()/2; i++) {
				st.add(str.charAt(i));
			}
			
			for (int i = str.length()/2; i < str.length(); i++) {
				if(!st.pop().equals(str.charAt(i))){
					return false;
				}
			}
			return true;
			//숫자가 홀 수 일 경우
		} else {
			for (int i = 0; i < str.length()/2; i++) {
				st.add(str.charAt(i));
			}
			
			for (int i = str.length()/2+1; i < str.length(); i++) {
				if(!st.pop().equals(str.charAt(i))){
					return false;
				}
			}
			return true;
		}
	}
}
