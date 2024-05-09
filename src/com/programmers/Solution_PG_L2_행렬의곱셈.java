package com.programmers;

import java.util.Arrays;

public class Solution_PG_L2_행렬의곱셈 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}},new int[][]{{3, 3}, {3, 3}}));
	}
	static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for(int i=0; i<arr1.length; i++){
			for(int j=0; j<arr2[0].length; j++){
				int now = 0;

				for(int j1=0; j1<arr1[0].length; j1++){
					now += arr1[i][j1]*arr2[j1][j];
				}
				answer[i][j] = now;
			}
		}

		System.out.println(Arrays.deepToString(answer));
		return answer;
	}
}
