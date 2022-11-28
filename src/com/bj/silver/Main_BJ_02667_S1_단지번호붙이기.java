package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_02667_S1_단지번호붙이기 {
	static int N, cnt;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] map;
	
	static void dfs(int y, int x) {
		cnt++;
		map[y][x] = '0';
		
		for (int i = 0; i < 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(0<=ny && ny<N && 0<=nx && nx<N) {
				if(map[ny][nx] != '0') dfs(ny, nx);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != '0') {
					cnt = 0;
					dfs(i, j);
					result.add(cnt);
				};
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
