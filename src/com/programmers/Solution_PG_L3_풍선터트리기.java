package com.programmers;

import java.util.*;

public class Solution_PG_L3_풍선터트리기 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
	}

	static int solution(int[] a) {
		int answer = 2;

		int leftMin = a[0];
		int rightMin = a[a.length-1];

		int[] left = new int[a.length];
		int[] right = new int[a.length];

		for(int i=1; i<a.length-1; i++){
			left[i] = Math.min(leftMin, a[i-1]);
			leftMin = Math.min(leftMin, a[i]);
		}

		for(int i=a.length-2; i>0; i--){
			right[i] = Math.min(rightMin, a[i+1]);
			rightMin = Math.min(rightMin, a[i]);
		}

		for(int i=1; i<a.length-1; i++){
			if(a[i]>left[i] && a[i]>right[i]) {
			} else {
				answer++;
			}
		}

		return answer;
	}
}
