package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14502_G4_연구소 {
	
	static int Y, X, max;
	static int[][] map, copy;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static void print() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				System.out.print(copy[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void virus() {
		boolean[][] visited = new boolean[Y][X];
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(copy[i][j] == 2 && !visited[i][j]) {
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i,j});
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						int size = q.size();
						for (int k = 0; k < size; k++) {
							int[] now = q.poll();
							
							for (int l = 0; l < 4; l++) {
								int ny = now[0] + dy[l];
								int nx = now[1] + dx[l];
								
								if(0<= ny && ny<Y && 0<=nx && nx<X && copy[ny][nx]==0 && !visited[ny][nx]) {
									copy[ny][nx] = 2;
									visited[ny][nx] = true;
									q.add(new int[] {ny, nx});
								}
							}
						}
					}
				}
			}
		}
		count();
	}
	
	static void count() {
		int cnt = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(copy[i][j] == 0) cnt++;
			}
		}
		
		max = Math.max(cnt, max);
	}
	
	static int[][] copy() {
		int[][] copy = new int[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}
	
	static void choice(int k, boolean[][] v) {
		if(k==3) {
			copy = copy();
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if(v[i][j]) copy[i][j] = 1;
				}
			}
			virus();
			
			return;
		}
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(map[i][j] == 0 && !v[i][j]) {
					v[i][j] = true;
					choice(k+1, v);
					v[i][j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		max = 0;
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] v = new boolean[Y][X];
		choice(0, v);
		
		System.out.println(max);
	}
}
