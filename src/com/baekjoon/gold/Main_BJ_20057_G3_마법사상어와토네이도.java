package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_20057_G3_마법사상어와토네이도 {
	static int N, ty, tx, depth, dir, toneMove;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int[][] board;
	
	static int[] tdy;
	static int[] tdx;
	
	//방향별 토네이도의 모래분배
	static void toneDir(int num) {
		if(num == 3) {
			tdy = new int[]{-1, 1, -2, 2, -1, 1, -1, 1, 0, 0};
			tdx = new int[]{1, 1, 0, 0, 0, 0, -1, -1, -2, -1};
		} else if(num == 1) {
			tdy = new int[]{-1, 1, -2, 2, -1, 1, 1, -1, 0, 0};
			tdx = new int[]{-1, -1, 0, 0, 0, 0, 1, 1, 2, 1};
		} else if(num == 2) {
			tdy = new int[]{1, 1, 0, 0, 0, 0, -1, -1, -2, -1};
			tdx = new int[]{-1, 1, -2, 2, -1, 1, 1, -1, 0, 0};
		} else if(num == 0){
			tdy = new int[]{-1, -1, 0, 0, 0, 0, 1, 1, 2, 1};
			tdx = new int[]{-1, 1, -2, 2, -1, 1, 1, -1, 0, 0};
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		ty = N/2;
		tx = N/2;
		
		//토네이도 이동을 위한 depth, toneMove;
		depth = 0;
		toneMove = 0;
		
		//최초 토네이도 방향
		dir = 3;
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		while(true) {
			int nowDir = dir;
			moveTone();
			toneDir(nowDir);
			int nowSand = board[ty][tx];
			int subSand = board[ty][tx];
			for (int i = 0; i < 9; i++) {
				int tny = ty+tdy[i];
				int tnx = tx+tdx[i];
				
				//각 위치마다 모래가 날리는 비율이 다르기에 구분해줍니다.
				if(i<2) {	//1%
					double dNum = subSand/100.0*1;
					int sSand = (int)dNum;
					
					if(0<=tny && tny<N && 0<=tnx && tnx<N) { //범위 안이라면
						nowSand -= sSand;
						board[tny][tnx] += sSand;
					} else { //범위를 벗어났다면
						nowSand -= sSand;
						res += sSand;
					}
					
				} else if(2<=i && i<4) { //2%
					double dNum = subSand/100.0*2;
					int sSand = (int)dNum;
					if(0<=tny && tny<N && 0<=tnx && tnx<N) { //범위 안이라면
						nowSand -= sSand;
						board[tny][tnx] += sSand;
					} else { //범위를 벗어났다면
						nowSand -= sSand;
						res += sSand;
					}
					
				} else if(4<=i && i<6) { //7%
					double dNum = subSand/100.0*7;
					int sSand = (int)dNum;
					if(0<=tny && tny<N && 0<=tnx && tnx<N) { //범위 안이라면
						nowSand -= sSand;
						board[tny][tnx] += sSand;
					} else { //범위를 벗어났다면
						nowSand -= sSand;
						res += sSand;
					}
					
				} else if(6<=i && i<8) { //10%
					double dNum = subSand/100.0*10;
					int sSand = (int)dNum;
					if(0<=tny && tny<N && 0<=tnx && tnx<N) { //범위 안이라면
						nowSand -= sSand;
						board[tny][tnx] += sSand;
					} else { //범위를 벗어났다면
						nowSand -= sSand;
						res += sSand;
					}
					
				} else if(i==8) { //5%
					double dNum = subSand/100.0*5;
					int sSand = (int)dNum;
					if(0<=tny && tny<N && 0<=tnx && tnx<N) { //범위 안이라면
						nowSand -= sSand;
						board[tny][tnx] += sSand;
					} else { //범위를 벗어났다면
						nowSand -= sSand;
						res += sSand;
					}
				}
			}

			//a위치로 모두 이동시킵니다.
			int tny = ty+tdy[9];
			int tnx = tx+tdx[9];
			
			if(0<=tny && tny<N && 0<=tnx && tnx<N) { //범위 안이라면
				board[tny][tnx] += nowSand;
				board[ty][tx] = 0;
			} else { //범위를 벗어났다면
				res += nowSand;
				board[ty][tx] = 0;
			}
			
//			System.out.println(cnt+"단계 이동 결과 " + ", 현재 방향  > "+ nowDir+" >" + ty+","+ tx);
//			for (int j = 0; j < N; j++) {
//				String now = "";
//				for (int j2 = 0; j2 < N; j2++) {
//					now += board[j][j2] + " ";
//				}
//				System.out.println(now);
//			}
//			System.out.println("---------------------------------------");
			
			//이번에 토네이도 위치가 0, 0이었으면 종료합니다.
			if(ty==0 && tx==0) break;
		}
		
		System.out.println(res);
	}
	
	//토네이도의 이동을 표현해줍니다.
	static void moveTone() {
		if(ty==tx && dir==3) { //depth가 늘어나야 할 때!
			depth++;
			dir = 0;
			toneMove = 0;
			tx--;
		} else {
			if(dir==0) {
				ty = ty+dy[dir];
				tx = tx+dx[dir];
				toneMove++;
				//밑으로 다 내려갔으니 다음 방향을 변경해줍니다.
				if(toneMove==(depth*2)-1) {
					dir++;
					toneMove = 0;
				}
			} else {
				ty = ty+dy[dir];
				tx = tx+dx[dir];
				toneMove++;
				//밑으로 다 내려갔으니 다음 방향을 변경해줍니다.
				if(toneMove==(depth*2) && dir<3) {
					dir++;
					toneMove = 0;
				}
			} 
		}
	}
}
