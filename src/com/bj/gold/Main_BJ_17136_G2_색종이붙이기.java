package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
0 0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

0 0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 0 0 0 0
0 1 1 1 1 1 0 0 0 0
0 0 1 1 1 1 0 0 0 0
0 0 1 1 1 1 0 0 0 0
0 1 1 1 1 1 1 1 1 1
0 1 1 1 0 1 1 1 1 1
0 1 1 1 0 1 1 1 1 1
0 0 0 0 0 1 1 1 1 1
0 0 0 0 0 1 1 1 1 1
*/


public class Main_BJ_17136_G2_색종이붙이기 {
	static int[][] map;
	static int[] gets;
	static int min;
	
	//덮을 수 있는지 체크
	static boolean ableCheck(int y, int x, int k) {
		for (int i = y; i <= y+k; i++) {
			for (int j = x; j <= x+k; j++) {
				if(map[y][x] != 1) return false;
			}
		}
		return true;
	}
	
	//덮는 행동을 해거나 말거나?
	static void dup(int y, int x, int k, int o) {
		for (int i = y; i <= y+k; i++) {
			for (int j = x; j <= x+k; j++) {
				if(o==1 && map[y][x] == 1) map[y][x] = 0;
				if(o==0 && map[y][x] == 0) map[y][x] = 1;
			}
		}
	}
	
	static void dfs(int y, int x, int cnt) {
		if(y == 9 && x == 9) {
			min = Math.min(cnt, min);
			return;
		}
		
		if(y>9) {
			dfs(y+1, 0, cnt);
			return;
		}
		
		if(map[y][x] == 1) {
			for (int i = 5; i>=1; i--) {
				if(ableCheck(y, x, i)) {
					dup(y, x, i, 1);
					gets[i]--;
					dfs(y+1, x, cnt+1);
					dup(y, x, i, 0);
				}
			}
			
		} else {
			
			dfs(y, x+1, cnt);
			return;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		gets = new int[6];
		min = Integer.MAX_VALUE;
		
		for (int i = 1; i < gets.length; i++) {
			gets[i] = 5;
		}
		
		for (int i = 0; i < 10; i++) {
			 st = new StringTokenizer(br.readLine());
			 for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		
	}
}
