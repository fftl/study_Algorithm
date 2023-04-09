package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_15683_G4_감시 {
	static int Y, X, minRes, E, ww;
	static int[][] board;
	static ArrayList<Pair> camera;
	
	public static class Pair{
		int y, x, k;
		public Pair(int y, int x, int k) {
			this.y = y;
			this.x = x;
			this.k = k;
		}
		@Override
		public String toString() {
			return "Pair [y=" + y + ", x=" + x + ", k=" + k + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		board = new int[Y][X];
		minRes = Y*X; //최소값을 구해야 하기 때문에 초기에는 최대 값으로 줍니다.
		camera = new ArrayList<>();
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num>0 && num<6) {
					camera.add(new Pair(i, j, num));
				}
				board[i][j] = num;
			}
		}
		
		//카메라 개수 확인
		E = camera.size();
		dfs(0);
	}
	
	static void dfs(int cnt) {
		if(cnt==E) {
			minCheck();
			return;
		}
		
		for (int i = cnt; i < E; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.println(i+","+j);
				camera.get(i).k=j;
				dfs(cnt+1);
			}
		}
	}
	
	static void minCheck() {
		int cnt = 0;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(board[i][j] == 0) cnt++;
			}
		}
		minRes = Math.min(cnt, minRes);
	}
}


