package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_01316_S5_그룹단어체커 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		
		//문자열을 하나씩 가지고 check 함수를 이용해서 판단해줍니다.
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			if(check(str)) result++;
		}
		
		System.out.println(result);
	}
	
	static boolean check(String str) {
		//이미 나왔던 문자를 체크해주기 위한 check 입니다.
		boolean[] check = new boolean[26];
		Stack<Character> st = new Stack<>();
		
		//문자열을 스택에 넣어주며 연속된 문자인지 확인합니다.
		//그리고 새로운 문자가 나온다면 해당 문자가 이미 check 문자인지 확인한 후에
		//아니라면 연속여부를 확인하고, 이미 나왔다면 false를 반환합니다.
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			if(st.empty()) {
				st.add(now);
				check[now-'a'] = true;
			} else {
				if(st.peek() == now) continue;
				else {
					st.pop();
					if(check[now-'a'] == true) return false;
					else {
						st.add(now);
						check[now-'a'] = true;
					}
				}
			}
		}
		
		return true;
	}
}
