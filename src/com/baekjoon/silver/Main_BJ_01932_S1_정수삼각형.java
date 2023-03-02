package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01932_S1_정수삼각형 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][1] = board[1][1];
		for (int i = 2; i <= n; i++) { // 첫째 줄은 위에서 더해줄 것이 없기 때문에 2번 줄 부터 시작합니다.
			for (int j = 1; j <= n; j++) {
				//삼각형의 가장 왼쪽일 경우
				if(j==1){
					dp[i][j] = dp[i-1][j]+board[i][j];

					//삼각형의 중앙일 경우(왼쪽상단, 오른쪽 상단 모두 가져올 수 있음)
				} else if (j<i){
					dp[i][j] = Math.max(dp[i-1][j-1]+board[i][j], dp[i-1][j]+board[i][j]);

					//삼각형의 가장 오른쪽일 경우
				} else {
					dp[i][j] = dp[i-1][j-1]+board[i][j];
				}
			}
		}

		//dp의 가장 마지막 줄에서 가장 큰 값을 구합니다.
		int result = 0;
		for (int i = 1; i <= n ; i++) {
			result = Math.max(dp[n][i], result);
		}

		System.out.println(result);
	}
}
