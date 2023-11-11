package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_10163_B1_색종이 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[1001][1001];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int a=x; a<x+w; a++) {
				for (int b=y; b <y+h; b++) {
					board[a][b] = i;
				}
			}
		}
		
		int idx = 1;
		while(idx<=N) {
			int nowCnt = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if(board[i][j] == idx) nowCnt++;
				}
			}
			System.out.println(nowCnt);
			idx++;
		}
		
	}

}
