package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_14466_G4_소가길을건너간이유6 {
	static int[][] map;
	static ArrayList<ArrayList<boolean[]>> dir;
	static int N, K, R;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];

		dir = new ArrayList<>();

		//각 좌표에서 특정 방향으로 길이 있는지 없는지 기록해줍니다.
		for (int i = 0; i < N+1; i++) {
			dir.add(new ArrayList<boolean[]>());
			for (int j = 0; j < N+1; j++) {
				dir.get(i).add(new boolean[4]);
			}
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int ay = Integer.parseInt(st.nextToken());
			int ax = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			int bx = Integer.parseInt(st.nextToken());
			
			check(ay, ax, by, bx);
		}
		
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			arr.add(new int[]{y, x});
		}

		int res = 0;
		for (int i = 0; i < K; i++) {
			int[] start = arr.get(i);
			for (int j = i+1; j < K; j++) {
				if(i==j) continue;
				boolean arrive = false;
				int[] end = arr.get(j);

				Queue<int[]> q = new LinkedList<>();
				boolean[][] visited = new boolean[N+1][N+1];

				q.add(new int[]{start[0],start[1]});
				visited[start[0]][start[1]] = true;

				while(!q.isEmpty()){

					int[] now = q.poll();
					if(now[0] == end[0] && now[1] == end[1]){
						arrive = true;
						break;
					}
					for (int k = 0; k < 4; k++) {
						if(dir.get(now[0]).get(now[1])[k]){
							continue;
						} else {
							int ny = now[0] +dy[k];
							int nx = now[1] +dx[k];
							if(0<ny && ny<=N && 0<nx && nx<=N && !visited[ny][nx]){
								q.add(new int[]{ny, nx});
								visited[ny][nx] = true;
							}
						}
					}
				}

				if(!arrive) res++;
			}
		}

		System.out.println(res);
	}


	//맵에서 길의 위치를 표시해줍니다!!
	static void check(int ay, int ax, int by, int bx) {
		//세로로 차이가 나는 위치라는 것
		if(ay-by != 0) {
			if(ay-by>0) {
				dir.get(ay).get(ax)[0]= true;
				dir.get(by).get(bx)[1]= true;
			} else {
				dir.get(ay).get(ax)[1]= true;
				dir.get(by).get(bx)[0]= true;
			}
			return;
		}
		
		//가로로 차이가 나는 위치라는 것		
		if(ax-bx != 0) {
			if(ax-bx>0) {
				dir.get(ay).get(ax)[2]= true;
				dir.get(by).get(bx)[3]= true;
			} else {
				dir.get(ay).get(ax)[3]= true;
				dir.get(by).get(bx)[2]= true;
			}
			return;
		}
	}
}
