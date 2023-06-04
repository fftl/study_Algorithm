package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_12852_S1_1로만들기2 {
	static int N, res;
	static String answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		res = Integer.MAX_VALUE;
		
		dfs(0, N, Integer.toString(N));
		System.out.println(res);
		System.out.println(answer);
	}
	
	//dfs를 통해서 모든 경우의 수를 보았습니다.
	static void dfs(int cnt, int now, String str) {
		
		//그리고 모든 경우의 수를 보지만 이미 1에 도달했던 횟수인 res보다
		//횟수가 높다면 탐색을 중단해주어 쓸데없는 탐색을 줄여주었습니다.
		if(cnt>res) return;
		
		if(now == 1) {
			res = Math.min(cnt, res);
			answer = str;
			return;
		}
		
		//문제에 주어진 조건에 따라서 값이 3으로 나누어 떨어지면 나누어주고
		//2로 나누어 떨어지면 나누어주고
		//아니라면 1만 빼주었습니다.
		if(now%3==0) dfs(cnt+1, now/3, str+" "+(now/3));
		if(now%2==0) dfs(cnt+1, now/2, str+" "+(now/2));
		dfs(cnt+1, now-1, str+" "+(now-1));
	}
}
