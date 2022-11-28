package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_13460_G1_구슬탈출2 {
	
	static int Y, X, result;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] red, blue, goal;
	static char[][] board;
	
	static void move(int d, int cnt, int[] nred, int[] nblue) {
//		System.out.println("=============================================");
//		System.out.println("현재좌표 >> " + Arrays.toString(nred)+ Arrays.toString(nblue)+" 현재방향 >> " +d);
		if(cnt>10) {return;}
		if(cnt>result) {return;}
		
		//각 구슬이 움직인 횟수! 더 많이 움직인 쪽이 더 뒤에 있었다는 의미가 됩니다.
		int rcnt = 0;
		int bcnt = 0;
		boolean rGoal = false;
		boolean bGoal = false;
		
		//빨간공 움직이기
		while(true) {
			nred[0] += dy[d];
			nred[1] += dx[d];
			
			rcnt++;
			//움직이는 도중에 goal에 들어갔다면
			if(nred[0] == goal[0] && nred[1] == goal[1]) {
//				System.out.println("redGoal >> " + rcnt);
				rGoal = true;
				break;
			//벽을 만났다면
			} else if(board[nred[0]][nred[1]] == '#') {
				nred[0] -= dy[d];
				nred[1] -= dx[d];
				rcnt--;
				break;
			}
		}
		
		//파란공 움직이기
		while(true) {
			nblue[0] += dy[d];
			nblue[1] += dx[d];
			
			bcnt++;
			//움직이는 도중에 goal에 들어갔다면
			if(nblue[0] == goal[0] && nblue[1] == goal[1]) {
//				System.out.println("blueGoal >> " + bcnt);
				bGoal = true;
				break;
				
			//벽을 만났다면
			} else if(board[nblue[0]][nblue[1]] == '#') {
				nblue[0] -= dy[d];
				nblue[1] -= dx[d];
				bcnt--;
				break;
			}
		}
		//만약 빨간공은 들어가고 파란공은 안들어갔다면!!
//		System.out.println("1blueGoal >> " + bGoal + " redGoal >> " + rGoal );
		if(rGoal && !bGoal) {
//			System.out.println("찾았따!! >> " + cnt);
			result = Math.min(cnt, result);
			return;
		} else if(!rGoal && !bGoal){

//			System.out.println("2blueGoal >> " + bGoal + " redGoal >> " + rGoal );
			//만약 같은 위치에서 멈췄다면 더 많이 움직인 공을 뒤로 한칸 옮겨줍니다.
			if(nred[0] == nblue[0] && nred[1] == nblue[1]) {
				if(rcnt > bcnt) {
					nred[0] -= dy[d];
					nred[1] -= dx[d];
				} else {
					nblue[0] -= dy[d];
					nblue[1] -= dx[d];
				}
			}
			
			for (int i = 0; i < 4; i++) {
				if(i != d) {
//					System.out.println("TEST111!!");
					int[] nRed = new int[] {nred[0], nred[1]};
					int[] nBlue= new int[] {nblue[0], nblue[1]};
					move(i, cnt+1, nRed, nBlue);
//					System.out.println("TEST222!!");
				}
			}
		}
			
	}
	
	//각각의 필요한 오브젝트를 찾아냅니다.
	static void findObj() {
		goal = new int[2];
		red = new int[2];
		blue = new int[2];
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(board[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
				} else if(board[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
				} else if(board[i][j] == 'O') {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		board = new char[Y][X];
		result = 11;
		
		for (int i = 0; i < Y; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		findObj();
		for (int i = 0; i < 4; i++) {
//			System.out.println("스타트 방향 변경!!");
//			System.out.println("goal >> " + Arrays.toString(goal));
			int[] nRed = new int[] {red[0], red[1]};
			int[] nBlue= new int[] {blue[0], blue[1]};
			move(i, 1, nRed, nBlue);
		}
		
//		move(2, 1, red, blue);
//		move(3, 1, red, blue);
//		move(1, 1, red, blue);
//		move(0, 1, red, blue);
		
		if(result>10) result = -1;
		System.out.println(result);
	}
}

