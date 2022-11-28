package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01194_G1_달이차오른다가자 {
	static int Y, X, min;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] map;
	static int[][][] visited;
	
	static void run(int y, int x, int k, int len) {
		
		visited[y][x][k] = len;
		
		if(map[y][x] == '1') {
			min = Math.min(len, min);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(0<=ny && ny<Y && 0<=nx && nx<X && map[ny][nx] != '#' 
					&& visited[ny][nx][k]>len ) {
				if(map[ny][nx] == '.' || map[ny][nx] == '1' || map[ny][nx] == '0') {
					run(ny, nx, k, len+1);
					
				} else if(0 <= map[ny][nx]-'A' && map[ny][nx]-'A' <= 5) { // 문이라면!?
					int door = map[ny][nx]-'A';
					int a = 1<<door;
					if((k & a) == a) {	//근데 키가 있다면!?
						run(ny, nx, k, len+1);
					}
					
				} else if(96 < map[ny][nx] && map[ny][nx]<103) {
					int nkey = map[ny][nx]-'a';
					int a = 1<<nkey;
					run(ny, nx, k|a, len+1);
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		map = new char[Y][X];
		visited = new int[Y][X][64];
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				for (int j2 = 0; j2 < 64; j2++) {
					visited[i][j][j2] = Integer.MAX_VALUE;
				}
			}
		}
		
		for (int i = 0; i < Y; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(map[i][j] == '0') run(i, j, 0, 0);
			}
		}
		
		if(min == Integer.MAX_VALUE ) min=-1;
		System.out.println(min);
	}
}
