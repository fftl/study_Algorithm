package com.baekjoon.silver;

import java.util.Scanner;

public class Main_BJ_16953_S2_A_B {
	static long result;

	//cnt = 횟수, sum은 연산값, end는 목표값
	static void dfs(int cnt, long sum, long end) {
		//목표값보다 크거나 같으면 멈추기! (마이너스 연산이나 나눗셈은 없어서 기저조건은 이렇게)
		if(sum >= end) {
			if(sum == end) { //같다면 횟수를 기록!
				result = Math.min(result, cnt);
				return;
			}
			return;
		}
		
		//현재값에서 *2 연산
		dfs(cnt+1, sum*2, end);
		
		//현재값+"1" 연산
		dfs(cnt+1, Long.parseLong(Long.toString(sum)+"1"), end);
		
	}
	
	//숫자의 제약조건을 확인하지 못해 int로 했다가 틀림
	public static void main(String[] args) throws Exception{
		
		//데이터를 입력받습니다.
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		result = Long.MAX_VALUE;
		dfs(1, a, b);
		
		//연산을 끝냈는데 result가 초기 값과 같다면 연산 종료!
		if(result == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
		
		sc.close();
	}

}
