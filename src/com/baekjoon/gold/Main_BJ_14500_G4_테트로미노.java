package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_14500_G4_테트로미노 {
	
	static int Y, X;
	static int[][] board;
	static class Tetro{
		int[] dy, dx;

		public Tetro(int[] dy, int[] dx) {
			super();
			this.dy = dy;
			this.dx = dx;
		}

		@Override
		public String toString() {
			return "Tetro [dy=" + Arrays.toString(dy) + ", dx=" + Arrays.toString(dx) + "]";
		}
		
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		board = new int[Y][X];
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(Arrays.deepToString(board));
	}
}
