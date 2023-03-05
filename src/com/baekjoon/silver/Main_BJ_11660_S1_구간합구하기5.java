package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11660_S1_구간합구하기5 {

	public static void main(String[] args) throws Exception {
		
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		
		//n의 크기의 board와 dp를 선언 및 초기화 시켜줍니다.
		int[][] board = new int[n][n];
		int[][] dp = new int[n][n];
		
		//board를 채워줍니다.
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//dp의 0, 0을 채워주고 크기에 맞는 누적합을 구해줍니다.
		dp[0][0] = board[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i==0 && j==0) continue;
				
				if(i==0) {
					dp[i][j] = dp[i][j-1]+board[i][j];
				} else if(j==0) {
					dp[i][j] = dp[i-1][j]+board[i][j];
				} else {
					dp[i][j] = dp[i-1][j]+dp[i][j-1]+board[i][j] - dp[i-1][j-1];
				}
			}
		}
		
		//요구사항에 맞는 sx, sy, ex, ey를 에 맞는 범위의 누적합을 구해줍니다.
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			int ex = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			
			//dp[ex][ey]를 기준으로 누적합을 구하게 되기에 먼저 구해놓습니다.
			int end = dp[ex][ey];
			
			//시작점, 종료점이 같다면 그냥 해당 좌표 수를 반환합니다.
			if(sx==ex && sy==ey) {
				System.out.println(board[sx][sy]);
				continue;
			}
			
			//시작점이 0,0 이라면 따로 계산할 필요 없이 누적합을 반환합니다.
			if(sx == 0 && sy == 0) {
				System.out.println(end);
				
			//시작점이 최상단에 붙어있다면, 왼쪽부분만 제거해주면 됩니다.
			} else if(sx == 0){
				System.out.println(end-dp[ex][sy-1]);
				
			//시작점이 가장 왼쪽에 붙어있다면 위쪽 부분만 제거해주면 됩니다.
			} else if(sy == 0) {
				System.out.println(end-dp[sx-1][ey]);
			
			//위의 모든 경우에 걸리지 않았다면 최상단, 가장 좌측을 빼주고 두가지에 중복하여 들어간 sx-1, sy-1 좌표를 더해주어 누적합을 구해줍니다.
			} else {
				System.out.println(end-dp[sx-1][ey]-dp[ex][sy-1]+dp[sx-1][sy-1]);
			}
			
		}
	}
}
