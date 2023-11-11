package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_09095_S3_123더하기 {
	
	static int cnt, target;
	
	static void dfs(int now) {
		//타겟을 넘으면 종료
		if(now>target) return;
		
		//타겟과 일치하면 cnt를 증가시키고 종료
		if(now == target) {
			cnt++;
			return;
		}
		
		for (int i = 1; i <= 3; i++) dfs(now+i);
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			//각 테스트 케이스마다 cnt와 target을 초기화시켜줍니다.
			cnt = 0;
			target = Integer.parseInt(br.readLine());
			
			//각 숫자로 시작하는 경우를 만들어줍니다.
			for (int j = 1; j <= 3; j++) dfs(j);
			System.out.println(cnt);
		}
	}
}
