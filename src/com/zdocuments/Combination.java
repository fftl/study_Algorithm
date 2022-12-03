package com.zdocuments;

import java.util.Arrays;

public class Combination {
	
	static int N, R, totalCount;
	static int[] numbers = {1,2,3,4,5},ans;
	
	public static void main(String[] args) {
		N = numbers.length;
		R = 3;
		ans = new int[R];
		combination(0,0);
		System.out.println("===> "+totalCount);
	}

	private static void combination(int index,int cnt) {
		if(cnt == R) {
			totalCount++;
			System.out.println(Arrays.toString(ans));
			return;
		}
		for (int i = index; i < N; i++) {
			ans[cnt] = numbers[i];
			combination(i+1, cnt+1);
		}
	}
}
