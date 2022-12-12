package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_09019_G4_DSLR {
	
	static String result;
	static int resSize, target;
	
	static void dfs(String cmd, char c, String num, int cnt) {
		System.out.println(cmd);
		if(cnt>resSize) return;
		
		int nowRes = 0;
		if(c=='D') {
			int now = Integer.parseInt(num);
			if(now*2 > 9999) nowRes = (now*2)%10000; 
			else nowRes = now*2;
			
		} else if(c=='S') {
			int now = Integer.parseInt(num);
			if(now == 0) nowRes = 9999;
			else nowRes = now-1;
			
		} else if(c=='L') {
			String now = num.substring(1, num.length()) + num.charAt(0);
			nowRes = Integer.parseInt(now);
			
		} else {
			String now = num.charAt(num.length()-1)+num.substring(0, num.length()-1);
			nowRes = Integer.parseInt(now);
			
		}
		
		if(nowRes == target) {
			if(cmd.length()<resSize) {
				result = cmd;
				resSize = cmd.length();
			}
		} else {
			dfs(cmd+"D", 'D', Integer.toString(nowRes), cnt+1);
			dfs(cmd+"S", 'S', Integer.toString(nowRes), cnt+1);
			dfs(cmd+"L", 'L', Integer.toString(nowRes), cnt+1);
			dfs(cmd+"R", 'R', Integer.toString(nowRes), cnt+1);
		}
	}

	public static void main(String[] args) throws Exception{
		
		//D - n의 값을 두배로 바꿉니다. 값이 9999를 넘어간다면 10000으로 나눈 나머지를 취합니다.
		//S - n에서 1을 뺀 결과 n-1을 저장합니다. n이 0이었다면 9999값이 저장됩니다.
		//L - n의 각 자리수를 왼쪽으로 한칸씩 밀어냅니다. 
		//R - n의 각 자리수를 오른쪽으로 한칸씩 밀어냅니다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			
			//A, B (0<= n <10000)(A != B)
			int A = Integer.parseInt(st.nextToken()); 
			target = Integer.parseInt(st.nextToken());
			resSize = Math.min(Math.abs(target-A), A+(10000-target));
			
			//DFS?
			dfs("D", 'D', Integer.toString(A), 1);
			dfs("S", 'S', Integer.toString(A), 1);
			dfs("L", 'L', Integer.toString(A), 1);
			dfs("R", 'R', Integer.toString(A), 1);
			
			System.out.println(result);
		}
	}
}
