package com.programmers;

import java.util.*;

public class Solution_PG_L2_짝지어제거하기 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution("baabaa"));
	}

	static int solution(String s)
	{
		int answer = 1;
		Stack<Character> st = new Stack<>();
		st.add(s.charAt(0));

		int idx = 1;
		while(idx<s.length()){
			if(!st.isEmpty()){
				if(st.peek() == s.charAt(idx)){
					st.pop();
				} else {
					st.add(s.charAt(idx));
				}
			} else {
				st.add(s.charAt(idx));
			}

			idx++;
		}

		if(!st.isEmpty()) return 0;
		else return 1;
	}
}
