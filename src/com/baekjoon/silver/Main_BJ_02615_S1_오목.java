package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02615_S1_오목 {
	
	static int[][] map;
	static int[] dy = {1, 0, 1, -1};
	static int[] dx = {0, 1, 1, 1};
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[19][19];
		
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if(map[i][j] != 0) {
					int dol = map[i][j];
					for (int k = 0; k < 4; k++) {
						int cnt = 1;
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						while(0<=ny && ny<19 && 0<=nx && nx<19 && map[ny][nx] == dol) {
							cnt++;
							ny = ny + dy[k];
							nx = nx + dx[k];
						}
						
						if(cnt == 5) {
							ny = ny + (dy[k]*-1);
							nx = nx + (dx[k]*-1);
							while(0<=ny && ny<19 && 0<=nx && nx<19 && map[ny][nx] == dol) {
								cnt--;
								ny = ny + (dy[k]*-1);
								nx = nx + (dx[k]*-1);
							}
							
							if(cnt==0) {
								System.out.println(dol);
								System.out.println((i+1)+" "+(j+1));
								return;
							}
							
						}
						
					}
				}
			}
		}
		
		System.out.println(0);
		
	}
}
