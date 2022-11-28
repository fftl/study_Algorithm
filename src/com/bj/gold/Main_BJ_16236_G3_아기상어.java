package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16236_G3_아기상어 {
	static ArrayList<int[]> fishs, possible;
	static PriorityQueue<int[]> pq;
	static int N, babySize, eat;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] baby;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		babySize = 2; // 아기상어의 사이즈
		baby = new int[2];	//아기상어의 위치
		eat = 0; // 얼마나 먹었는지
		map = new int[N][N]; //map!

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				//상어일 경우 위치를 담아주고, 상어의 위치는 0으로 바꿔줍니다.
				if (n == 9) {
					baby[0] = i;
					baby[1] = j;
					map[i][j] = 0;
					continue;
				}
			}
		}

		//상어가 먹을 수 있는 먹이들을 담습니다.
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] != o2[2]) {
					return o1[2] - o2[2];
				} else {
					if (o1[0] != o2[0]) {
						return o1[0] - o2[0];
					} else {
						return o1[1] - o2[1];
					}
				}
			}
		});
		
		int t = 0;
		while(true) {
			visited = new boolean[N][N];
			Queue<int[]> q = new LinkedList<>();
			visited[baby[0]][baby[1]] = true;
			q.add(baby);
			
			int len = 1;
			while(!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] now = q.poll();
					for (int j = 0; j < 4; j++) {
						int ny = now[0] + dy[j];
						int nx = now[1] + dx[j];
						//아기상어가 갈 수 있는 방향이고 아기상어보다 크기가 작다면
						//해당 방향을 q에 담아줍니다.
						if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx] <= babySize && !visited[ny][nx]) {
							if (map[ny][nx] == babySize || map[ny][nx] == 0) {
								visited[ny][nx] = true;
								q.add(new int[] {ny, nx});
							} else {
								//먹을 수 있는 물고기는 pq에 담아주어 가장 조건에 알맞는 물고기를 찾아줍니다.
								visited[ny][nx] = true;
								pq.add(new int[] {ny, nx, len});
								q.add(new int[] {ny, nx});
							}
						}
					}
				}
				if(!pq.isEmpty()) break;
				len++;
			}
			
			//먹을수 있는 물고기가 없다면 종료!
			if(pq.isEmpty()) break;
			int[] f = pq.poll();
			pq.clear();
			//먹이를 먹었으니 0으로 바꿔주고 상어의 위치를 해당 좌표로 바꿔줍니다.
			map[f[0]][f[1]] = 0;
			baby[0] = f[0];
			baby[1] = f[1];
			t+=f[2];
			
			//먹이를 크기만큼 먹으면 아기상어가 성장합니다.
			eat++;
			if(eat==babySize) {
				babySize++;
				eat = 0;
			}
		}
		
		System.out.println(t);
	}
}
