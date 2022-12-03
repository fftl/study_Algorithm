package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02468_S1_안전영역 {
	static int N, max, result, cnt;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	static int[][] board;
	static boolean[][] visited;
	
	static void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(0<= ny && ny<N && 0<=nx && nx<N) {
				if(board[ny][nx] != -1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		result = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int high = Integer.parseInt(st.nextToken());
				max = Math.max(high, max);
				board[i][j] = high;
			}			
		}
		
		//now을 물의 높이라고 지정했습니다.
		//물의 높이를 1씩 높이며 dfs로 를 이용해서 잠기는 부분들을 처리 해주고,
		//영역의 개수를 세어주었습니다.
		int now = 1;
		while(now<max) {
			//물에 잠기는 것을 표현!
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(board[i][j] <= now) {
						board[i][j] = -1;
					}
				}
			}
			
			//이번 물이 잠기고 난 뒤의 영역의 개수를 세어줍니다. 
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && board[i][j] != -1) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			result = Math.max(cnt, result);
			now++;
		}

		System.out.println(result);
	}

}
