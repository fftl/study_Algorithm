package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14500_G4_테트로미노 {
	
	static int Y, X, max;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static void run(int y, int x, int dep, int val) {
		if(dep == 4) {
			max = Math.max(max, val);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(0<=ny && ny<Y && 0<=nx && nx<X && !visited[ny][nx]) {
				visited[ny][nx] = true;
				run(ny, nx, dep+1, val+board[ny][nx]);
				visited[ny][nx] = false;
			}
		}
	}
	
	static void other(int y, int x, int val) {
		
		//오른쪽 가위!
		int rightVal = val;
		int rightGo = 0;
		boolean right = false;
		int ny = y + dy[3];
		int nx = x + dx[3];		
		while(0<=ny && ny<Y && 0<=nx & nx<X) {
			rightVal += board[ny][nx];
			rightGo++;
			if(rightGo==2) {
				right = true;
				break;
			};
			
			ny = ny + dy[3];
			nx = nx + dx[3];
		}
		
		if(right) {
			ny = ny + dy[2];
			nx = nx + dx[2];
			
			int upNy = ny + dy[0];
			int upNx = nx + dx[0];
			if(0<=upNy && upNy<Y && 0<=upNx && upNx<X) {
				max = Math.max(max, rightVal+board[upNy][upNx]);
			}
			
			int downNy = ny + dy[1];
			int downNx = nx + dx[1];
			if(0<=downNy && downNy<Y && 0<=downNx && downNx<X) {
				max = Math.max(max, rightVal+board[downNy][downNx]);
			}
		}
		
		//아래쪽 가위!
		int downVal = val;
		int downGo = 0;
		boolean down = false;
		int dny = y + dy[1];
		int dnx = x + dx[1];		
		while(0<=dny && dny<Y && 0<=dnx & dnx<X) {
			downVal += board[dny][dnx];
			downGo++;
			if(downGo==2) {
				down = true;
				break;
			};
			
			dny = dny + dy[1];
			dnx = dnx + dx[1];
		}
		
		if(down) {
			dny = dny + dy[0];
			dnx = dnx + dx[0];
			
			int leftNy = dny + dy[2];
			int leftNx = dnx + dx[2];
			if(0<=leftNy && leftNy<Y && 0<=leftNx && leftNx<X) {
				max = Math.max(max, downVal+board[leftNy][leftNx]);
			}
			
			int rightNy = dny + dy[3];
			int rightNx = dnx + dx[3];
			if(0<=rightNy && rightNy<Y && 0<=rightNx && rightNx<X) {
				max = Math.max(max, downVal+board[rightNy][rightNx]);
			}
		}
		
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		max = 0;
		
		board = new int[Y][X];
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[Y][X];
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				visited[i][j] = true;
				run(i, j, 1, board[i][j]);
				other(i, j, board[i][j]);
			}
		}
		
		System.out.println(max);
	}
}
