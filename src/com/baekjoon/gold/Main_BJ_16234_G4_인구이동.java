package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_16234_G4_인구이동 {
	static int N,L,R, result;
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<int[]> point;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean stop;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		visited = new boolean[N][N];
		point = new ArrayList<>();
		result = 0;
		stop = false;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean moveRun = true;
		while(moveRun){
			moveRun = false;

			//방문처리를 초기화 해줍니다.
			setVisited();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]){
						boolean run = bfs(i, j);
						if(run) moveRun = true;
					}
				}
			}

			if(moveRun) result++;
		}

		System.out.println(result);
	}

	static void setVisited(){
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}

	static boolean bfs(int y, int x){
		boolean run = false;
		Queue<int[]> q = new LinkedList<>();
		ArrayList<int[]> logs = new ArrayList<>();

		int sum = board[y][x];
		int cnt = 1;

		q.add(new int[]{y, x});
		logs.add(new int[]{y, x});
		visited[y][x] = true;

		while(!q.isEmpty()){
			int[] now = q.poll();
			int nowVal = board[now[0]][now[1]];

			for (int i = 0; i < 4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				//일단 다음 스텝이 board 안에 포함되는지 확인합니다.
				if(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]){
					int nxtVal = board[ny][nx];
					int cha = Math.abs(nowVal-nxtVal);

					//현재와 다음 스텝의 차가 주어진 범위 안에 포함되는지 확인합니다.
					if(L<=cha && cha<=R){
						run = true;
						q.add(new int[]{ny, nx});
						logs.add(new int[]{ny, nx});

						cnt++;
						sum += nxtVal;

						//그룹으로 묶였으므로 방문처리를 해줍니다.
						visited[ny][nx] = true;
					}
				}
			}
		}

		int newValue = sum/cnt;

		for (int i = 0; i < logs.size(); i++) {
			int[] now = logs.get(i);
			board[now[0]][now[1]] = newValue;
		}

		return run;
	}
}
