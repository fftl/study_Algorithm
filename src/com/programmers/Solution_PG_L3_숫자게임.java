package com.programmers;

import java.util.*;

public class Solution_PG_L3_숫자게임 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new int[]{5,1,3,7},new int[]{2,2,6,8}));
	}

	static int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int answer = 0;
		int idx = 0;

		run : for(int i=0; i<A.length; i++){
			if(idx==A.length) break run;

			boolean in = false;
			while(A[i]>=B[idx]){
				in = true;
				idx++;
				if(idx==A.length) break run;
			}

			idx++;

			answer++;
		}

		return answer;
	}
}
