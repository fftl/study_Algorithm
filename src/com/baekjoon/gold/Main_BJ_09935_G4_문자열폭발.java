package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_09935_G4_문자열폭발 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String before = br.readLine();	//문자열
		String pok = br.readLine();		//폭발 문자열
		int len = pok.length();

		Stack<Character> st = new Stack<>();

		for (int i = 0; i < before.length(); i++) {
			//before의 문자를 하나씩 가져옵니다.
			char now = before.charAt(i);
			st.add(now);
			//st의 크기가 pok의 크기보다 작다면 계속 추가해주고, 같아지면 판단을 시작합니다.
			if(st.size()>=len){
				boolean check = true;
				for (int j = st.size()-len; j < st.size(); j++) {
					if(st.get(j) != pok.charAt(j-(st.size()-len))) {
							check = false;
							break;
						}
					}
				if(check){
					for (int j = 0; j < len; j++) {
						st.pop();
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int stSize = st.size();
		for (int i = 0; i < stSize; i++) {
			sb.append(st.pop());
		}

		if(sb == null || sb.length()==0) System.out.println("FRULA");
		else System.out.println(sb.reverse().toString());
	}
}
