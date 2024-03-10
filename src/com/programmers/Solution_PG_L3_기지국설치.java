package com.programmers;

public class Solution_PG_L3_기지국설치 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(11, new int[]{4, 11}, 1));
	}

	static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int len = 1+w*2;
		int start = 1;

		for(int i=0; i<stations.length; i++){
			int nowNum = stations[i]-w - start;

			answer += nowNum/len;
			if(nowNum%len>0) answer++;

			if(stations[i]+w+1 <= n){
				start = stations[i]+w+1;
			} else {
				break;
			}

			if(i == stations.length-1){
				nowNum = n - start + 1 ;

				answer += nowNum/len;
				if(nowNum%len>0) answer++;
			}
		}

		return answer;
	}
}
