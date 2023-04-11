package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_15864_G3_사다리조작 {
	static int X, M, Y;
	static int[][] board;
	
	static class Pair{
		int y, x;
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		board = new int[Y][X];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
		}
	}
	
	//사다리 체크
	static void runCheck() {
		
	}
	
	//사다리의 모든 경우를 확인합니다.
	static void dfs() {
		
	}
}
