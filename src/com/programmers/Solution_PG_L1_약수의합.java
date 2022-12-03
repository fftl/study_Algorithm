package com.programmers;

public class Solution_PG_L1_약수의합 {

	public static void main(String[] args) throws Exception {
		int n = 12;
		System.out.println(solution(n));
	}

	static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) if(n%i == 0) answer+=i;
        return answer;
    }
}
