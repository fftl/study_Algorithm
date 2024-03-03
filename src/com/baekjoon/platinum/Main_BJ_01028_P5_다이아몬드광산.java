package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01028_P5_다이아몬드광산 {
	static int Y, X;
	static char[][] board;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Y; i++) {
			board[i] = br.readLine().toCharArray();
		}
	}
}
