package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01992_S1_쿼드트리 {

	static int N, half;
	static char[][] arr;
	static StringBuilder sb, sub;
	static boolean end;

	
	public static void check(int y, int x, int s) { // y값, x값, size
		
		//해당 영역의 모든 수의 합을 구합니다.
		int sum = 0;
		for (int i = y; i < y + s; i++) {
			for (int j = x; j < x + s; j++) {
				sum += arr[i][j] - '0';
			}
		}
		
		//합계가 s*s 또는 0이 아니라면 압축될 수 없는 영상입니다.
		if (sum == 0 || sum == s*s) {
			if (sum == 0)
				sb.append("0");
			else
				sb.append("1");
		} else {
			int newS = s / 2;
			
			//해당 부분을 괄호로 묶어주며
			sb.append("(");
			check(y, x, newS);  			//좌상단
			check(y, x + newS, newS);		//우상단
			check(y + newS, x, newS);		//좌하단
			check(y + newS, x + newS, newS);//우하단 순으로 네모를 줄여 탐색을 계속합니다.
			sb.append(")");
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		//데이터 arr 만들기!
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		check(0, 0, N);
		System.out.println(sb.toString());
	}
}
