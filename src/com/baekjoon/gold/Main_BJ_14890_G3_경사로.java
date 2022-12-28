package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14890_G3_경사로 {
	
	static int N, L, result;
	static int[][] board;
	
	static void lineCheck(int i) {
		//가로부터
		int before = board[i][0];
		boolean[] check = new boolean[N];
		boolean able = true;
		
		run : for (int j = 1; j < N; j++) {
			int now = board[i][j];
			if(check[j]) {
				before = now;
				continue;
			}
			
			//높이가 달라졌다면?
			if(before != now) {
				//높이의 차가 2 이상이면 경사로를 놓을 수 없다.
				if(Math.abs(before-now)>1) {
					able = false;
					break run;
				} else {
					//내리막 경사로가 필요하다면!
					if(before>now) {
						int nj = j;	//경사로를 놓을 수 있는 평편한 땅을 세기 위한 다음 땅의 index입니다.
						int cnt = 0;	//가능한 평평한 땅의 개수입니다.
						
						//board가 끝나지 않을때까지 확인
						while(nj<N){
							
							//경사로 밑면의 개수와 평평한 땅의 길이가 같다면 반복을 멈춥니다.
							if(cnt == L) break;
							
							//만약 다음 땅이 현재 땅과 높이가 같다면 평평한 땅 입니다.
							if(board[i][nj]==now) {
								cnt++;
							} else {
								break;
							}
							nj++;
						}
						
						//위의 while문을 거치며 결과적으로 경사로를 놓을 수 있다면 입니다.
						//check에다가 경사로가 이미 놓여진 땅이라고 표시를 해줍니다.
						if(cnt == L) {
							for (int k = j; k < j+L; k++) check[k] = true;
						} else {
							able = false;
							break run;
						}
						
					//오르막 경사로가 필요하다면!
					} else {
						int cnt = 0;
						int nj = j-1;
						while(0 <= nj) {
							if(cnt == L) break;
							if(board[i][nj] == before && !check[nj]) {
								cnt++;
							} else {
								break;
							}
							nj--;
						}
						if(cnt == L) {
							for (int k=j-1; j-L<=k; k--) check[k] = true;
						} else {
							able = false;
							break run;
						}
					}
				}
			}
			before = now;
		}
		
		if(able) result++;
		
		//세로
		before = board[0][i];
		check = new boolean[N];
		able = true;
		
		run : for (int j = 1; j < N; j++) {
			int now = board[j][i];
			if(check[j]) {
				before = now;
				continue;
			}
			
			//높이가 달라졌다면?
			if(before != now) {
				//높이의 차가 2 이상이면 경사로를 놓을 수 없다.
				if(Math.abs(before-now)>1) {
					able = false;
					break run;
				} else {
					//내리막 경사로가 필요하다면!
					if(before>now) {
						int nj = j;	//경사로를 놓을 수 있는 평편한 땅을 세기 위한 다음 땅의 index입니다.
						int cnt = 0;	//가능한 평평한 땅의 개수입니다.
						
						//board가 끝나지 않을때까지 확인
						while(nj<N){
							
							//경사로 밑면의 개수와 평평한 땅의 길이가 같다면 반복을 멈춥니다.
							if(cnt == L) break;
							
							//만약 다음 땅이 현재 땅과 높이가 같다면 평평한 땅 입니다.
							if(board[nj][i]==now) {
								cnt++;
							} else {
								break;
							}
							nj++;
						}
						
						//위의 while문을 거치며 결과적으로 경사로를 놓을 수 있다면 입니다.
						//check에다가 경사로가 이미 놓여진 땅이라고 표시를 해줍니다.
						if(cnt == L) {
							for (int k = j; k < j+L; k++) check[k] = true;
						} else {
							able = false;
							break run;
						}
						
					//오르막 경사로가 필요하다면!
					} else {
						int cnt = 0;
						int nj = j-1;
						while(0 <= nj) {
							if(cnt == L) break;
							if(board[nj][i] == before && !check[nj]) {
								cnt++;
							} else {
								break;
							}
							nj--;
						}
						if(cnt == L) {
							for (int k=j-1; j-L<=k; k--) check[k] = true;
						} else {
							able = false;
							break run;
						}
					}
				}
			}
			before = now;
		}
		
		if(able) result++;
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//가로 탐색
		for (int i = 0; i < N; i++) {
			lineCheck(i);
		}
		
		System.out.println(result);
	}
}
