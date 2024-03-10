package com.programmers;

public class Solution_PG_L3_최고의집합 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(2, 9));
	}

	static int[] solution(int n, int s) {
		int[] answer = new int[n];

		if(n>s){
			return new int[]{-1};
		}

		int plusCnt = 0;
		if(s%n == 0){
			for(int i=0; i<n; i++){
				answer[i] = s/n;
			}
		} else {
			int sum = (s/n) * n;
			while(sum<s){
				plusCnt++;
				sum++;
			}
		}

		int insert = s/n;
		for(int i=n-1; i>=0; i--){
			if(plusCnt>0) {
				answer[i] = insert+1;
				plusCnt--;
			} else {
				answer[i] = insert;
			}
		}

		return answer;
	}
}
