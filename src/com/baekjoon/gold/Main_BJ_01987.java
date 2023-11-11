package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01987_G4_알파벳 {
	
	static int Y, X, max;
	static int[] dy = {0, 0, 1, -1};
	static int[] dx = {1, -1, 0, 0};
	static boolean[] alpha;
	static char[][] board;
	
	static boolean dfs(int y, int x, int cnt) {
		max = Math.max(cnt, max);
		

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			//상하좌우를 탐색하며 아직 가지 않았던 알파벳이라면 들어가서 확인을 해줍니다.			
			if(0<=ny && ny<Y && 0<=nx && nx<X) {
				if(!alpha[board[ny][nx]]) {
					alpha[board[ny][nx]] = true;
					
					if(dfs(ny, nx, cnt+1)) {
						return true;
					}
				}
			}
		}
		
		//해당 알파벳으로 들어 왔는데, 더이상 갈 곳이 없다면 false로 바꿔준뒤 다시 뒤로 돌아갑니다.
		alpha[board[y][x]] = false;
		return false;
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		max = 0;
		
		//보드 칸을 만들어줍니다.
		board = new char[Y][X];
		
		//알파벳에 방문여부를 확인하기 위해서 boolean 배열을 만들었습니다.
		//char 65=='A' ~ 91=='Z' 이므로 각 알파벳이 나온다면 해당 인덱스를 true 표시합니다.
		alpha = new boolean[92];
 		
		for (int i = 0; i < Y; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		//첫 위치는 일단 방문표시 합니다.
		alpha[board[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(max);
		
	}
}
