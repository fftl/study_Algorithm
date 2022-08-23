package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/board/view/90094 반례
public class Main_BJ_13460_G1_구슬탈출2 {
	static int Y, X, result;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] blue, red, end;
	static char[][] board;
	static boolean[][] visited;
	
	static void run(int cnt, int by, int bx, int ry, int rx) {
		System.out.println(ry+","+rx+","+by+","+bx);
		for(int i=0; i<4; i++) {
			int bny = by+dy[i];
			int bnx = bx+dx[i];
			
			int rny = by+dy[i];
			int rnx = bx+dx[i];
			int bCnt = 0;
			int rCnt = 0;
			
			boolean bCheck = false; //가는도중에 골인지점을 만났는지 확인
			boolean bin = false;
			if(1<=bny && bny<Y-1 && 1<=bnx && bnx<X-1 && board[bny][bnx] == '.') { //범위 내에 있고
				System.out.println("t1");
				System.out.println(bny+","+bnx+","+board[bny][bnx]);
				bin = true;
				bCnt++;
				bny+=dy[i];
				bnx+=dx[i];
				if(bny == end[0] && bnx == end[1]) bCheck=true;
			}
			boolean rCheck = false; //가는도중에 골인지점을 만났는지 확인
			boolean rin = false;
			while(1<=rny && rny<Y-1 && 1<=rnx && rnx<X-1 && board[rny][rnx] == '.') { //범위 내에 있고
				System.out.println("t2");
				rin = true;
				rCnt++;
				rny+=dy[i];
				rnx+=dx[i];
				if(rny == end[0] && rnx == end[1]) rCheck=true;
			}
			if(rin) {
				rny-=dy[i];
				rnx-=dx[i];
			}
			
			//공이 하나라도 빠졌다면 일단 해당 탐색은 종료.
			if(rCheck && !bCheck) {
				result = Math.min(result, cnt);
				return;
			}
			if(!rCheck && bCheck) return;
			if(rCheck && bCheck) return;
			
			//한쪽 방향으로 기울었는데 같은 지점에 두 공이 멈춰섰다면 더 멀리 이동한(가고자 하는 방향에서 더 멀리있던 공을 한칸 뒤로 빼줍니다. )
			if(bny==rny && bnx==rnx) {
				if(bCnt>rCnt) {
					bny -= dy[i];
					bnx -= dx[i];
				} else {
					rny -= dy[i];
					rnx -= dx[i];
				}
			}
			
//			run(cnt+1, bny, bnx, rny, rnx);			
			System.out.println(rny+","+rnx+","+bny+","+bnx);
			System.out.println("-------------------------------");
		}
		return;
	}
	
	//초기의 각각 공과, 도착지점을 찾아줍니다.
	static void find() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(board[i][j] == 'B') {
					blue[0] = i;
					blue[1] = j;
					board[i][j] = '.'; //공의 위치는 좌표로 관리할 것이기 때문에 비워줍니다.
				}
				if(board[i][j] == 'R') {
					red[0] = i;
					red[1] = j;
					board[i][j] = '.';
				}
				if(board[i][j] == 'O') {
					end[0] = i;
					end[1] = j;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken()); // y
		X = Integer.parseInt(st.nextToken()); // x
		board = new char[Y][X];
		visited = new boolean[Y][X];
		result = 11;
		for (int i = 0; i < Y; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		blue = new int[2];
		red = new int[2];
		end = new int[2];
		
		find();
		run(0, blue[0], blue[1], red[0], red[1]);
	}

}
