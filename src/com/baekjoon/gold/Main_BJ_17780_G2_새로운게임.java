package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_17780_G2_새로운게임 {
	static int N, K;
	static int[][] board;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {1, -1, 0, 0};
	static Deque<Unit>[][] dq;
	static HashMap<Integer, int[]> index;
	static boolean dead;

	static class Unit{
		int id, k;

		public Unit(int id, int k) {
			this.id = id;
			this.k = k;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Unit{");
			sb.append("id=").append(id);
			sb.append(", k=").append(k);
			sb.append('}');
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		//맵 생성
		board = new int[N][N];

		//맵 채우기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//각 맵에 체스가 쌓이는 것을 표현해 줄 dq와
		//각 체스말의 위치를 빠르게 찾기 위한 index
		dq = new Deque[N][N];
		index = new HashMap<>();

		//체스말 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dq[i][j] = new ArrayDeque();
			}
		}

		//입력으로 받는 체스말을 입력해줍니다.
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int k = Integer.parseInt(st.nextToken())-1;

			dq[y][x].add(new Unit(i, k));

			index.put(i, new int[]{y, x});
		}
		
		int time = 0;
		//매번 종료조건을 확인하며 종료 조건을 갖추면 종료합니다.
		while(end(time)){
			time++;
			move();
		}

		if(dead) System.out.println(-1);
		else System.out.println(time);
	}

	//종료 조건을 판단.
	//한 칸에 네개의 체스가 쌓였거나 time이 1000번이 넘으면 종료.
	static boolean end(int time){
		if(time>1000) {
			dead = true;
			return false;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dq[i][j].size()>=4) return false;
			}
		}
		
		return true;
	}

	//현재 dq 두개를 이용해서 해당 id 체스말의 위에 있는 애들만 옮겨주고 아닌 애들은
	//다시 남기는 부분을 진행하고 있음
	static void move(){
		for (int i = 0; i < K; i++) {
			int[] now = index.get(i);
			Deque<Unit> temp = new ArrayDeque<>();
			Unit nu = dq[now[0]][now[1]].peekFirst();

			//가장 아래에 있는 체스말이 현재 인덱스 체스말과 같을 때만 이동할 수 있음.
			if(nu.id == i){
				int ny = now[0] + dy[nu.k];
				int nx = now[1] + dx[nu.k];

				if(0<=ny && ny<N && 0<=nx && nx<N && board[ny][nx] != 2){
					if(board[ny][nx] == 0){
						while(!dq[now[0]][now[1]].isEmpty()){
							Unit unit = dq[now[0]][now[1]].pollFirst();
							index.put(unit.id, new int[]{ny, nx});
							dq[ny][nx].add(unit);
						}
					} else {
						while(!dq[now[0]][now[1]].isEmpty()){
							Unit unit = dq[now[0]][now[1]].pollLast();
							index.put(unit.id, new int[]{ny, nx});
							dq[ny][nx].add(unit);
						}
					}

				} else {
					nu.k = turn(nu.k);
					int rny = now[0] + dy[nu.k];
					int rnx = now[1] + dx[nu.k];
					if(0<=rny && rny<N && 0<=rnx && rnx<N && board[rny][rnx] != 2) {
						if(board[rny][rnx] == 0){
							while(!dq[now[0]][now[1]].isEmpty()){
								Unit unit = dq[now[0]][now[1]].pollFirst();
								index.put(unit.id, new int[]{rny, rnx});
								dq[rny][rnx].add(unit);
							}
						} else {
							while(!dq[now[0]][now[1]].isEmpty()){
								Unit unit = dq[now[0]][now[1]].pollLast();
								index.put(unit.id, new int[]{rny, rnx});
								dq[rny][rnx].add(unit);
							}
						}
					}
				}
			}
		}
	}

	static int turn(int n){
		if(n==0) return 1;
		else if(n==1) return 0;
		else if(n==2) return 3;
		else return 2;
	}
}
