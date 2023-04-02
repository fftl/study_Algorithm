package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_14499_G4_주사위굴리기 {
	static int N, M, y, x, K; //보드 크기 N, M / 시작 주사위 좌표 y, x / 명령어 개수 K
	static int[][] board;  	  //바닥을 표현해 줄 board
	static int[] dy = {0, 0, 0, -1, 1};	//주사위의 이동을 표현해줄 dy, dx
	static int[] dx = {0, 1, -1, 0, 0};
	static int[] dice;	//주사위의 각 면의 숫자들을 표현해 줄 dice
	
	public static void main(String[] args) throws Exception{
		
		//주어진 입력값들을 입력 받습니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		dice = new int[] {0, 0, 0, 0, 0, 0, 0};
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				board[i][j] = val;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//명령어들을 하나씩 받아내며 주사위의 이동을 표현해줍니다.
		for (int i = 0; i < K; i++) {
			
			//명령어를 하나 받습니다.
			int k = Integer.parseInt(st.nextToken());
			
			//명령어에 맞는 방향으로 다음 방향을 미리 가봅니다.
			int ny = y + dy[k];
			int nx = x + dx[k];
			
			//만약 보드의 범위를 벗어나지 않는다면 주사위의 이동을 합니다.
			if(0<=ny && ny<N && 0<=nx && nx<M) {
				
				//주사위를 이동시켜줍니다.
				y = ny;
				x = nx;
				
				
				if(k==1) { // 동쪽이라면
					
					//주사위가 굴러서 이동하며 변경되는 수 들을 표현해주었습니다.
					dice = new int[]{dice[0], dice[3], dice[2], dice[6], dice[1], dice[5], dice[4]};
					
					//문제에서 주어진 조건에 따라서 보드의 바닥이 0일라면 주사위 바닥인 dice[1]을 바닥에 복사해줍니다.
					if(board[y][x] == 0) board[y][x] = dice[1];
					else {	//보드의 바닥이 0이 아니라면 주사위의 바닥인 dice[1]에 보드의 숫자를 붙여준 뒤 보드의 수는 0으로 만들어줍니다.
						dice[1] = board[y][x];
						board[y][x] = 0;
					}
					
					// 아래부터는 위와 같은 방식을 방향별로 표현해줍니다.
				} else if(k==2) {	//서쪽이라면
					dice = new int[]{dice[0], dice[4], dice[2], dice[1], dice[6], dice[5], dice[3]};
					if(board[y][x] == 0) board[y][x] = dice[1];
					else {
						dice[1] = board[y][x];
						board[y][x] = 0;
					}
					
				} else if(k==3) {	//북쪽이라면
					dice = new int[]{dice[0], dice[2], dice[6], dice[3], dice[4], dice[1], dice[5]};
					if(board[y][x] == 0) board[y][x] = dice[1];
					else {
						dice[1] = board[y][x];
						board[y][x] = 0;
					}
					
				} else {	//남쪽이라면
					dice = new int[]{dice[0], dice[5], dice[1], dice[3], dice[4], dice[6], dice[2]};
					if(board[y][x] == 0) board[y][x] = dice[1];
					else {
						dice[1] = board[y][x];
						board[y][x] = 0;
					}
				}
				
				//이동이 끝난 뒤 주시위의 상단인 dice[6]을 StringBuilder에 입력해줍니다.
				sb.append(dice[6]+"\n");
			} else { // 발판을 넘어가는 명령은 무시합니다.
				continue;
			}
		}
		
		//결과적으로 만들어진 StringBuilder를 출력해줍니다.
		System.out.println(sb.toString().trim());
	}
}
