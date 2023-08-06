package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_18808_G3_스티커붙이기 {
	static int N, M, K;
	static boolean[][] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			
			//i번째 스티커를 받아냅니다.
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			boolean[][] now = new boolean[y][x];
			
			for (int j = 0; j < y; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < x; k++) {
					if(st.nextToken().equals(1)) now[j][k] = true;
					else now[j][k] = false;
				}
			}
			
			//받아낸 스티커 now를 board에 대입해봅니다.
			
		}
	}
	
	public static boolean insert(boolean[][] now, int y, int x) {
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
			}
		}
		return false;
	}
	
	//회전 시키는 것을 표현해줍니다.
	public static boolean[][] turn(boolean[][] now) {
		return null;
	}
}
