package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_02206_G3_벽부수고이동하기 {
	
	static int Y, X, result;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] board;
	static ArrayList<int[]> block;
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[Y][X][2];
		
		q.add(new int[] {0,0,0});
		visited[0][0][0] = true;
		int dep = 1;
		
		while(!q.isEmpty()) {
			if(dep>=result) return;
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				if(now[0] == Y-1 && now[1] == X-1) {
					result = Math.min(result, dep);
					return;
				}
				
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
					
					if(0<=ny && ny<Y && 0<=nx && nx<X) {
						//벽에 도착했는데
						if(board[ny][nx] == 1) {
							if(now[2] == 0) {
								if(!visited[ny][nx][1]) {
									visited[ny][nx][1] = true;
									q.add(new int[] {ny, nx, 1});
								}
							} 
						} else {
							if(now[2]<2) {
								if(!visited[ny][nx][now[2]]) {
									visited[ny][nx][now[2]] = true;
									q.add(new int[] {ny, nx, now[2]});
								}
							}
						}
					}
				}
			}
			
			dep++;
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		result = 1000*1000;
		
		board = new int[Y][X];
		block = new ArrayList<>();
		
		for (int i = 0; i < Y; i++) {
			String[] strs = br.readLine().split("");
			for (int j = 0; j < X; j++) {
				int now = Integer.parseInt(strs[j]);
				if(now == 1) block.add(new int[] {i, j});
				board[i][j] = now;
			}
		}
		
		bfs();
		
		if(result == 1000*1000) System.out.println(-1);
		else System.out.println(result);
	}
}
