package com.pg;

public class Solution_PG_L1_평균구하기 {

	public static void main(String[] args) throws Exception {
		int[] arr = {1,2,3,4};
		System.out.println(solution(arr));
	}

	static double solution(int[] arr) {
        double answer = 0;
        for(int i=0; i<arr.length; i++) answer += arr[i];
        return answer/arr.length;
    }
}
