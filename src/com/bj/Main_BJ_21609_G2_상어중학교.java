package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_21609_G2_상어중학교 {

	static int N, M, maxCnt;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dX = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> bk;
	
	static void bfs() {
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < dX.length; j++) {
				if(visited[i][j]) continue;
				
				int num = map[i][j];
				if(num == -1 || num==0) continue;
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {i,j});
				visited[i][j] = true;
				
				while(!q.isEmpty()) {
					int size = q.size();
					for (int k = 0; k < size; k++) {
						int[] now = q.poll();
						int nowy = now[0];
						int nowx = now[1];
						
					}
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
