package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_01799_P5_비숍 {
	static int N, white, black, result;
	static int[][] board;
	static int[] dy = {-1,-1,1,1};
	static int[] dx = {-1,1,-1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		white = 0;
		black = 0;

		board = new int[N][N];
		int[][] wBoard = new int[N][N];
		int[][] bBoard = new int[N][N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				wBoard[i][j] = (num == 0) ? -1 : 0; //0일 경우에는 놓을 수 없는 칸이다, -1로 표시해줍니다.
				bBoard[i][j] = (num == 0) ? -1 : 0;
			}
		}

		whiteCount(wBoard, 0, 0,0);
		blackCount(bBoard, 0, 1, 0);
		System.out.println(white+black);
	}

	static int[] nextWhite(int ny, int nx) {
		if (nx + 2 < N) return new int[]{ny, nx+2};
		else {
			if(ny+1<N){
				if((ny+1)%2==0){
					return new int[]{ny+1, 0};
				} else{
					return new int[]{ny+1, 1};
				}
			} else {
				return new int[]{-1, -1};
			}
		}
	}

	static int[] nextBlack(int ny, int nx) {
		if (nx + 2 < N) return new int[]{ny, nx+2};
		else {
			if(ny+1<N){
				if((ny+1)%2==0){
					return new int[]{ny+1, 1};
				} else{
					return new int[]{ny+1, 0};
				}
			} else {
				return new int[]{-1, -1};
			}
		}
	}

	static void whiteCount(int[][] nBoard, int y, int x, int cnt){
		white = Math.max(cnt, white);
		if(y==-1) return;

		int[] nxt = nextWhite(y, x);

		if(nBoard[y][x] == -1){
			whiteCount(nBoard, nxt[0], nxt[1], cnt);
		} else {
			boolean able = true;
			for(int k=0; k<4; k++){
				if(!able) break;
				int ny = y;
				int nx = x;
				while(0<=ny && ny<N && 0<=nx && nx<N){
					if(nBoard[ny][nx] > 0){ //놓을 수 없는 칸이라면
						able = false;
					}
					ny = ny+dy[k];
					nx = nx+dx[k];
				}
			}

			if(!able){ whiteCount(nBoard, nxt[0], nxt[1], cnt);}
			else{
				whiteCount(nBoard, nxt[0], nxt[1], cnt);
				nBoard[y][x] = 1;
				whiteCount(nBoard, nxt[0], nxt[1], cnt+1);
				nBoard[y][x] = 0;
			}
		}
	}

	static void blackCount(int[][] nBoard, int y, int x, int cnt){
		black = Math.max(cnt, black);
		if(y==-1) return;

		int[] nxt = nextBlack(y, x);

		if(nBoard[y][x] == -1){
			blackCount(nBoard, nxt[0], nxt[1], cnt);
		} else {
			boolean able = true;
			for(int k=0; k<4; k++){
				if(!able) break;
				int ny = y;
				int nx = x;
				while(0<=ny && ny<N && 0<=nx && nx<N){
					if(nBoard[ny][nx] > 0){ //놓을 수 없는 칸이라면
						able = false;
					}
					ny = ny+dy[k];
					nx = nx+dx[k];
				}
			}

			if(!able){ blackCount(nBoard, nxt[0], nxt[1], cnt);}
			else{
				blackCount(nBoard, nxt[0], nxt[1], cnt);
				nBoard[y][x] = 1;
				blackCount(nBoard, nxt[0], nxt[1], cnt+1);
				nBoard[y][x] = 0;
			}
		}
	}

//	static void countResult(){
//		for(int i=0; i<N; i++){
//			for(int j=0; j<N; j++) {
//				if(board[i][j] == -1) continue;
//				int min = Integer.MAX_VALUE;
//				int[] point = {-1, -1};
//
//				for(int k=0; k<4; k++){
//					int ny = i;
//					int nx = j;
//					while(0<=ny && ny<N && 0<=nx && nx<N){
//						if(cBoard[ny][nx] >= 0){ //놓을 수 있는 칸이라면
//							if(cBoard[ny][nx]<min){
//								min = cBoard[ny][nx];
//								point[0] = ny;
//								point[1] = nx;
//							}
//						}
//						ny = ny+dy[k];
//						nx = nx+dx[k];
//					}
//				}
//
//				for(int k=0; k<4; k++){
//					int ny = i;
//					int nx = j;
//					while(0<=ny && ny<N && 0<=nx && nx<N){
//						if(ny != point[0] || nx != point[1]){
//							board[ny][nx] = -1;
//						}
//						ny = ny+dy[k];
//						nx = nx+dx[k];
//					}
//				}
//
//				result++;
//			}
//
//		}
//	}

//	static void countBoard(){
//		for(int i=0; i<N; i++){
//			for(int j=0; j<N; j++) {
//				if(board[i][j] == -1) continue;
//				int count = 0;
//
//				for(int k=0; k<4; k++){
//					int ny = i+dy[k];
//					int nx = j+dx[k];
//					while(0<=ny && ny<N && 0<=nx && nx<N){
//						if(board[ny][nx] == 0){ //놓을 수 있는 칸이라면
//							count++;
//						}
//						ny = ny+dy[k];
//						nx = nx+dx[k];
//					}
//				}
//				cBoard[i][j] = count;
//			}
//		}
//	}
}

