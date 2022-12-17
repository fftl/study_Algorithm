package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01780_S2_종이의개수 {
	
	static int a, b, c; // a는 -1의 개수, b는 0의 개수, c는 1의 개수
	
	static int check(int[][] board) {
		int nowA = 0;
		int nowB = 0;
		int nowC = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int now = board[i][j];
				if(now==-1) nowA++;
				else if(now==0) nowB++;
				else nowC++;
			}
		}
		
		if(nowB==0 && nowC==0) {
			return -1;
		} else if(nowA==0 && nowC==0) {
			return 0;
		} else if(nowA==0 && nowB==0) {
			return 1;
		} else {
			return 9;
		}
	}
	
	static void run(int[][] board, int size) {
		int check = check(board);
		if(check<9) {
			if(check == -1) a++;
			else if(check == 0) b++;
			else c++;
		} else {
			int mini = size/3;
			if(mini == 1) {
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if(board[i][j] == -1) a++;
						else if(board[i][j] == 0) b++;
						else c++;
					}
				}
			} else {
				for (int i = 0; i < size; i+=3) {
					for (int j = 0; j < size; j+=3) {
						int[][] nowBoard = new int[mini][mini];
						for (int i2 = i; i2 < i+mini; i2++) {
							for (int j2 = j; j2 < j+mini; j2++) {
								nowBoard[i2-i][j2-j] = board[i2][j2];
							}
						}
						run(nowBoard, mini);
					}
				}
				
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		a = 0; b = 0; c = 0;
		
		run(board, n);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
