package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_16724_G3_피리부는사나이 {
	static int N, M, cnt;
	static char[][] board;
	static int[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		visited = new int[N][M];
		cnt = N*M;
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		int res = 0;
		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] == 0) {
					int ny = i;
					int nx = j;
					visited[ny][nx] = idx;
					while(true) {
						char now = board[i][j];
						int[] d = dir(now);
						ny = d[0] + ny;
						nx = d[1] + nx;
						
						if(visited[ny][nx] == 0) {
							
						}
					}
				}
			}
		}
	}
	
	static int[] dir(char c) {
		if(c=='D') return new int[] {1, 0};
		else if(c=='L') return new int[] {0, -1};
		else if(c=='R') return new int[] {0, 1};
		else return new int[] {0, -1};
	}
}
