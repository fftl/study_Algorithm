package com.programmers;

public class Solution_PG_L2_다음큰숫자 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(78));
	}

	static int solution(int n) {
		int answer = 0;
		int nCnt = half(n);

		int nxt = n+1;
		while(true){
			if(half(nxt) == nCnt){
				break;
			} else {
				nxt++;
			}
		}

		return nxt;
	}

	static int half(int num){
		int cnt = 0;

		while(num>0){
			if(num%2!=0){
				cnt++;
			}
			num /= 2;
		}

		return cnt;
	}
}
