package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17070_G5_파이프옮기기1 {
	static int N, result;
	static int[] a, b;
	static int[] dy = {0, 1, 1};
	static int[] dx = {1, 1, 0};
	static int[][] map;
	
	static void move(int k, int ay, int ax, int by, int bx) {
		int ny = -1;
		int nx = -1;
		int cnt = 0;
		switch(k) {
		case 0:
			ny = ay + dy[0];
			nx = ax + dx[0];
			if(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] != 1) {
				ay += dy[0];
				ax += dx[0];
				by += dy[0];
				bx += dx[0];
			} else { return; }
			break;
			
		case 1:
			for (int i = 0; i < 3; i++) {
				ny = ay + dy[i];
				nx = ax + dx[i];
				if(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] != 1) {
					cnt++;
				}
			}
			
			if(cnt == 3) {
				by = ay;
				bx = ax;
				ay += dy[1];
				ax += dx[1];
			}  else { return; }
			
			break;
		case 2:
			
			ny = ay + dy[2];
			nx = ax + dx[2];
			if(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] != 1) {
				ay += dy[2];
				ax += dx[2];
				by += dy[2];
				bx += dx[2];
			}  else { return; }
			
			break;
		}
		
		if(ay == N-1 && ax == N-1) {
			result++;
			return;
		}
		
		if(k == 0) {
			move(0, ay, ax, by, bx);
			move(1, ay, ax, by, bx); 
		} else if(k == 1) {
			move(0, ay, ax, by, bx);
			move(1, ay, ax, by, bx);
			move(2, ay, ax, by, bx);
		} else {
			move(1, ay, ax, by, bx);
			move(2, ay, ax, by, bx);
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		result = 0;
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(0, 0, 1, 0, 0);
		move(1, 0, 1, 0, 0);
		
		System.out.println(result);
	}
}
