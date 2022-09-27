package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*		
4 5 1
4 1 2 3 3
6 1 1 3 3
5 6 1 3 2
5 5 6 5 5
*/

public class Main_BJ_23288_G3_주사위굴리기2 {
	
	static int Y, X, K, y, x, d;
	static int[] dice;
	static int[] dy = {0, 0, 1, -1}; //동서남북
	static int[] dx = {1, -1, 0, 0}; //동서남북
	static int[][] map;
	static void roll(int k) {
		int[] copy = new int[6];
		switch(k) {
		case 0: //동
			copy[1] = dice[3];
			copy[2] = dice[2];
			copy[3] = dice[6];
			copy[4] = dice[1];
			copy[5] = dice[5];
			copy[6] = dice[4];
			break;
		case 1: //서
			copy[1] = dice[4];
			copy[2] = dice[2];
			copy[3] = dice[1];
			copy[4] = dice[6];
			copy[5] = dice[5];
			copy[6] = dice[3];
			break;
		case 2: //남
			copy[1] = dice[5];
			copy[2] = dice[1];
			copy[3] = dice[3];
			copy[4] = dice[4];
			copy[5] = dice[6];
			copy[6] = dice[2];
			break;
		case 3: //북
			copy[1] = dice[2];
			copy[2] = dice[6];
			copy[3] = dice[3];
			copy[4] = dice[4];
			copy[5] = dice[1];
			copy[6] = dice[5];
			break;
		}
		
		dice = copy;
	}
	
	static int bfs() {
		return 0;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X= Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		y = 1;
		x = 1;
		int k = 0;
		
		map = new int[Y+1][X+1];
		dice = new int[] {0, 1,2,3,4,5,6};
		
		
		for (int i = 1; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(K>0) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			//가야할 방향으로 갈 수 있다면
			if(0<ny && ny<=Y && 0<nx && nx<=X) {
				roll(k);
			} else {
				switch(k) {
				case 0:
					roll(1);
					ny = y+dy[1];
					nx = x+dx[1];
					break;
				case 1:
					roll(0);
					ny = y+dy[0];
					nx = x+dx[0];
					break;
				case 2:
					roll(3);
					ny = y+dy[3];
					nx = x+dx[3];

					break;
				case 3:
					roll(2);
					ny = y+dy[2];
					nx = x+dx[2];

					break;
				}
			}
			y = ny;
			x = nx;
			
			int a = dice[0];
			int b = map[y][x];
			K--;
		}
		
		
		
		
		
	}
}
