package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
					if(st.nextToken().equals("1")) now[j][k] = true;
					else now[j][k] = false;
				}
			}
			
			//받아낸 스티커 now를 board에 대입해봅니다.
			insert(now, y, x);
//			System.out.println(i+"---------------------------------------------");
		}
		
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j]) res++;
			}
		}
		
		System.out.println(res);
	}
	
	public static void insert(boolean[][] now, int y, int x) {
		
		boolean end = false;
		
		
		for (int t = 0; t < 4; t++) {
			int r = now.length;
			int c = now[0].length;
			
			if(end) break;
			i : for (int i = 0; i <= N-r; i++) {
				j : for (int j = 0; j <= M-c; j++) {
					
					for (int k = 0; k < r; k++) {
						for (int w = 0; w < c; w++) {
							//노트북과, 스티커가 겹치는 부분이 있다면 해당 위치에는 못놓습니다.
							if(board[i+k][j+w] && now[k][w]) {
								continue j;
							}
						}
					}
					
					//여기까지 왔다면 스티커를 놓을 수 있는 상태입니다.
					//board에 스티커를 채워줍니다.
					for (int k = 0; k < r; k++) {
						for (int w = 0; w < c; w++) {
							//노트북과, 스티커가 겹치는 부분이 있다면 해당 위치에는 못놓습니다.
							if(now[k][w]) board[i+k][j+w] = now[k][w];
						}
					}
					
//					System.out.println("현재상황입니다 --");
//					System.out.println(Arrays.deepToString(board));
					end = true;
					break i;
				}
			}
			if(!end) { 
				now = turn(now, r, c);
				
			}
		}
	}
	
	//회전 시키는 것을 표현해줍니다.
	public static boolean[][] turn(boolean[][] now, int y, int x) {
		boolean[][] newStk = new boolean[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				newStk[i][j] = now[y-1-j][i];
			}
		}
		
//		System.out.println(Arrays.deepToString(newStk));
		return newStk;
	}
}
