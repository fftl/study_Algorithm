package com.pg;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_PG_L2_문자열압축 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution("abcabcabcabcdededededede"));
	}
	
	static int solution(String s) {
		int answer = 0;
		int size = s.length();
		int min = Integer.MAX_VALUE;
		
		Queue<String> q = new LinkedList<>();
		for (int i = 1; i < size/2; i++) {
			System.out.println("---------------------------------");
			String nowResult = "";
			for (int j = 0; j < size-i; j+=i) {
				String nowStr = s.substring(j, j+i);
				if(!q.isEmpty()) {
					q.add(nowStr);
				} else {
					if(nowStr.equals(q.peek())) {
						q.add(nowStr);
					} else {
						if(q.size() == 1) {
							nowResult += q.poll();
							q.add(nowStr);
						} else {
							nowResult += q.size()+q.poll();
							q.clear();
							q.add(nowStr);
						}
					}
				}
			}
			System.out.println(nowResult);
		}
		
		return answer;
	}
}
