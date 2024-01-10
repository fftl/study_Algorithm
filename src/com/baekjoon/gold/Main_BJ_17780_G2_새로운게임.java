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

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dq = new Deque[N][N];
		index = new HashMap<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dq[i][j] = new ArrayDeque();
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int k = Integer.parseInt(st.nextToken())-1;

			dq[y][x].add(new Unit(i, k));

			index.put(i, new int[]{y, x});
		}
		
		int time = 0;
		while(end(time)){
			
		}
	}

	static boolean end(int time){
		if(time>1000) return false;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dq[i][j].size()==4) return false;
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
			if(nu.id == i){
				int ny = now[0] + dy[nu.k];
				int nx = now[1] + dx[nu.k];
				if(0<=ny && ny<N && 0<=nx && nx<N && board[ny][nx] != 2){
					if(board[ny][nx] == 0){

					}
				} else {

				}
			} else {
			}

		}
	}
}
