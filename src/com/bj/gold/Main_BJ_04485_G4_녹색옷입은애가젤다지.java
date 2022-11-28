package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_04485_G4_녹색옷입은애가젤다지 {

	//각 좌표와 가중치를 담을 Point 입니다.
	static class Point{
		int x, y, w;

		public Point(int y, int x, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
	}
	
	static int N, min;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map, size;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			map = new int[N][N];
			size = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					size[i][j] = Integer.MAX_VALUE;
				}
			}
			
			min = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			visited[0][0] = true;
			
			//우선순위큐를 이용하여 가중치가 가장 적은 것을 우선해서 뽑아냅니다.
			PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					return o1.w-o2.w;
				}
			});
			pq.add(new Point(0, 0, map[0][0]));
			
			while(!pq.isEmpty()) {
				Point now = pq.poll();
				for (int i = 0; i < 4; i++) {
					int ny = now.y+dy[i];
					int nx = now.x+dx[i];
					
					//범위내에 있고, 현재 사이즈보다 더 적은 방법으로 갈 수 있을 경우에만 size를 갱신해주고 pq에 추가해줍니다.
					if(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx] && size[ny][nx] >(map[ny][nx] + now.w)) {
						size[ny][nx] = map[ny][nx] + now.w;
						visited[ny][nx] = true;
						pq.add(new Point(ny, nx, size[ny][nx]));
					}
				}
			}
			
			System.out.println("Problem "+idx+": "+size[N-1][N-1]);
			idx++;
		}
	}
}
