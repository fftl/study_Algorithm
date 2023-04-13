package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_15684_G3_사다리조작 {
	
	static int X, M, Y;
	static HashMap<int[], int[]> def;
	static boolean[][] board, copy;
	static boolean end;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		def = new HashMap<>();
		
		board = new boolean[Y][X];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = true;
			board[r][c+1] = true;
			def.put(new int[]{r, c}, new int[]{r, c+1});
			def.put(new int[]{r, c+1}, new int[]{r, c});
		}


		copy = copyBoard();
		print();
		if(!sadariCheck()){
			return;
		}

		end = false;
		boolean[][] visited = new boolean[Y][X];

		if(runCheck()) {
			System.out.println(0);
			return;
		}
		dfs(0, 1, visited);
		if(end) {
			System.out.println(1);
			return;
		}
		dfs(0, 2, visited);
		if(end) {
			System.out.println(2);
			return;
		}
		dfs(0, 3, visited);
		if(end) {
			System.out.println(3);
		}else{
			System.out.println(-1);
		}
	}

	//처음에 놓여있는 사다리를 포함한 맵을 복사합니다.
	static boolean[][] copyBoard(){
		boolean[][] copy = new boolean[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				copy[i][j] = board[i][j];
			}
		}
		return copy;
	}
	
	//사다리의 모든 경우를 확인합니다.
	static void dfs(int cnt, int maxCnt, boolean[][] visited){
		if(end) return;

		if(cnt == maxCnt){
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (visited[i][j]) copy[i][j] = true;
				}
			}
			if(runCheck()){
				end = true;
				return;}

			copy = copyBoard();
			return;
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X-1; j++) {
				if(copy[i][j] || visited[i][j]) continue;
				
				
				visited[i][j] = true;
				visited[i][j+1] = true;
				dfs(cnt+1, maxCnt, visited);
				visited[i][j] = false;
				visited[i][j+1] = false;
			}
		}
	}

	static boolean sadariCheck(){
		for (int i = 0; i < Y; i++) {
			int max = copy[i][0] ? 1 : 0;
			for (int j = 1; j < X; j++) {
				if(copy[i][j-1] && copy[i][j]) max++;
				else if (!copy[i][j-1] && copy[i][j]){
					max=1;
				}
			}
			if(max>=3) return false;
		}
		return true;
	}

	//사다리가 i->i로 이동하는지 확인
	static boolean runCheck() {
		for (int j = 0; j < X; j++) {
			int s = 0;
			int x = j;
			while(true){
				if(s==Y){
					if(x != j) return false; //다른곳으로 도착했다면 false
					else break; //같은 곳으로 도착했다면 다음 줄을 확인합니다.
				}

				if(copy[s][j]){
					if(0<=x-1 && copy[s][x-1]) {
						x--;
					} else if(x+1<X&& copy[s][x+1]) {
						x++;
					}
					s++;
				} else {
					s++;
				}
			}
		}
		return true;
	}

	public static void print(){
		for (int i = 0; i < Y; i++) {
			String str = "";
			for (int j = 0; j < X; j++) {
				if (copy[i][j]) str += "1 ";
				else str += "0 ";
			}
			System.out.println(str);
		}
	}
}
