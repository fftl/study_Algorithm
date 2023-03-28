package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_03190_G4_뱀 {
	static int N, K, L, direct, s; //direct - 방향, s - 시간
	static boolean[][] apple, board;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static Queue<int[]> que;
	static int[] head;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		//사과 받아서 지정해놓기
		apple = new boolean[N][N];
		board = new boolean[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			apple[y][x] = true;
		}

		L = Integer.parseInt(br.readLine());
		que = new LinkedList<>();
		head = new int[] {0,0};
		que.add(head);
		direct = 0;
		s = 0;
		boolean end = false;
		
		runFor: for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			
			while(s<r) {
				int ny = head[0]+dy[direct];
				int nx = head[1]+dx[direct];
				s++;
				
				//벽 안으로 이동한다면
				if(0<=ny && ny<N && 0<=nx && nx<N) {
					
					//내 몸에 부딪힌다면
					if(board[ny][nx]) {
						end = true;
						break runFor;
					}
					
					board[ny][nx] = true;
					head[0] = ny;
					head[1] = nx;
					que.add(new int[]{ny, nx});
					
					if(apple[ny][nx]) {
						apple[ny][nx] = false;
					} else {
						int[] now = que.poll();
						board[now[0]][now[1]] = false;
					}
					
				} else {
					end = true;
					break runFor;
				}
			}
			
			if(d == 'D') {
				if(direct < 3) direct++;
				else direct = 0;
			} else {
				if(direct > 0) direct--;
				else direct = 3;
			}
			
		}
		
		while(!end) {
			int ny = head[0]+dy[direct];
			int nx = head[1]+dx[direct];
			s++;
			
			//벽 안으로 이동한다면
			if(0<=ny && ny<N && 0<=nx && nx<N) {
				
				//내 몸에 부딪힌다면
				if(board[ny][nx]) {
					end = true;
					break;
				}
				
				board[ny][nx] = true;
				head[0] = ny;
				head[1] = nx;
				que.add(new int[] {ny,nx});
				
				if(apple[ny][nx]) {
					apple[ny][nx] = false;
				} else {
					int[] now = que.poll();
					board[now[0]][now[1]] = false;
				}
				
			} else {
				break;
			}
			
		}
		System.out.println(s);
	}
}
