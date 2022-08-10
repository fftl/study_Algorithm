package com.bj;

import java.util.Scanner;

public class Main_BJ_16953_S2_A_B {
	static long result;

	static void dfs(int cnt, long sum, long end) {
		if(sum >= end) {
			if(sum == end) {
				result = Math.min(result, cnt);
				return;
			}
			return;
		}
		
		dfs(cnt+1, sum*2, end);
		dfs(cnt+1, Long.parseLong(Long.toString(sum)+"1"), end);
		
	}
	
	//숫자의 제약조건을 확인하지 못해 int로 했다가 틀림
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		result = Long.MAX_VALUE;
		System.out.println(result);
		dfs(1, a, b);
		
		if(result == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		
		sc.close();
	}

}
