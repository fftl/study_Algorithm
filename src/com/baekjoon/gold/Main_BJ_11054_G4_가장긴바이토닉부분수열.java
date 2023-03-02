package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11054_G4_가장긴바이토닉부분수열 {
	static int N;
	static int[] board;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		// -- 데이터 입력 완료

		//정방향, 역방향에서 각 위치에 최대 증가 수열?을 찾아냅니다.
		int[] dpF = new int[N];
		int[] dpB = new int[N];
		dpF[0] = 1;
		dpB[N-1] = 1;

		//정방향에서의 가장 긴 증가 수열을 찾아냅니다.
		for (int i = 0; i < N; i++) {
			dpF[i] = 1;
			boolean check = false;
			int nowMax = 0;
			for (int j = 0; j < i; j++) {
				if(board[j]<board[i] && nowMax<dpF[j]) {
					nowMax = dpF[j];
					check = true;
				}
			}

			//하나라도 개수가 증가했다면?
			if(check){
				dpF[i] = nowMax+1;
			}
		}

		//역방향에서의 가장 긴 증가 수열을 찾아냅니다.
		for (int i = N-1; 0<=i; i--) {
			dpB[i] = 1;
			boolean check = false;
			int nowMax = 0;
			for (int j = N - 1; i <= j; j--) {
				if (board[j] < board[i] && nowMax < dpB[j]) {
					nowMax = dpB[j];
					check = true;
				}
			}

			//하나라도 개수가 증가했다면?
			if (check) {
				dpB[i] = nowMax + 1;
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(dpF[i]+dpB[i], result);
		}

		System.out.println(result-1);

	}
}
