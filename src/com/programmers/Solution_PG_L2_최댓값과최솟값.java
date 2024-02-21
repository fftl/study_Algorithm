package com.programmers;

import java.util.*;

public class Solution_PG_L2_최댓값과최솟값 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution("1 2 3 4"));
	}

	static String solution(String s) {
		String[] strs = s.split(" ");
		int[] nums = new int[strs.length];

		for(int i=0; i<strs.length; i++){
			nums[i] = Integer.parseInt(strs[i]);
		}

		Arrays.sort(nums);

		return nums[0]+" "+nums[strs.length-1];
	}
}
