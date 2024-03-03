package com.programmers;

public class Solution_PG_L2_숫자의표현 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(15));
	}

	static int solution(int n) {
		int answer = 0;
		int idx = 1;
		int first = 1;
		int now = 0;

		while(idx<=n+1){
			if(now==n){
				answer++;
				now += idx;
				idx++;
			} else if(now<n){
				now += idx;
				idx++;
			} else if(now>n){
				now -= first;
				first++;
			}
		}
		return answer;
	}
}
