package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_02638_G3_치즈 {
	static int N, M; //맵의 크기
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] board;
	static ArrayList<int[]> cz;
	static Queue<int[]> del;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		cz = new ArrayList<>();
		del = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) cz.add(new int[] {i, j});
			}
		}
		
		Queue<int[]> outSide = new LinkedList<>();
		outSide.add(new int[] {0, 0});
		board[0][0] = 9;
		
		while(!outSide.isEmpty()) {
			int[] now = outSide.poll();
			for (int j = 0; j < 4; j++) {
				int ny = now[0]+dy[j];
				int nx = now[1]+dx[j];
				
				if(0<=ny && ny<N && 0<=nx && nx<M && board[ny][nx] == 0) {
					board[ny][nx] = 9;
					outSide.add(new int[] {ny, nx});
				}
			}
		}
		
		int result = 0;
		while(cz.size()>0) {
			for (int i = 0; i < cz.size(); i++) {
				int[] now = cz.get(i);
				int cnt = 0;
				for (int j = 0; j < 4; j++) {
					int ny = now[0]+dy[j];
					int nx = now[1]+dx[j];
					
					if(0<=ny && ny<N && 0<=nx && nx<M && board[ny][nx] == 9) cnt++;
				}
				//만약 이번 치즈가 두면 이상이 공기에 접촉해 있다면 del 목록에 추가시켜줍니다.
				if(cnt >=2) {
					del.add(now);
				}
			}
			
			while(!del.isEmpty()) {
				int[] now = del.poll();
				cz.remove(now);
				board[now[0]][now[1]] = 9;
				outSide.add(now);
			}
			
			while(!outSide.isEmpty()) {
				int[] now = outSide.poll();
				for (int j = 0; j < 4; j++) {
					int ny = now[0]+dy[j];
					int nx = now[1]+dx[j];
					
					if(0<=ny && ny<N && 0<=nx && nx<M && board[ny][nx] == 0) {
						board[ny][nx] = 9;
						outSide.add(new int[] {ny, nx});
					}
				}
			}
			
			result++;
		}
		
		System.out.println(result);
	}
}
