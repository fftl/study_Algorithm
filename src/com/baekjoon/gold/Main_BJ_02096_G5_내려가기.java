package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02096_G5_내려가기 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		int[][] board = new int[t][3];
		int[][] max = new int[t][3];
		int[][] min = new int[t][3];
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			board[i][0] = a;
			board[i][1] = b;
			board[i][2] = c;
		}
		max[0][0] = board[0][0];
		max[0][1] = board[0][1];
		max[0][2] = board[0][2];
		
		min[0][0] = board[0][0];
		min[0][1] = board[0][1];
		min[0][2] = board[0][2];
		
		for (int i = 1; i < t; i++) {
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + board[i][0];
			max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + board[i][1];
			max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + board[i][2];
			
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + board[i][0];
			min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + board[i][1];
			min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + board[i][2];
		}
		
		int maxResult = Math.max(Math.max(max[t-1][0], max[t-1][1]), max[t-1][2]);
		int minResult = Math.min(Math.min(min[t-1][0], min[t-1][1]), min[t-1][2]);
		
		System.out.println(maxResult+" "+minResult);
	}
}
