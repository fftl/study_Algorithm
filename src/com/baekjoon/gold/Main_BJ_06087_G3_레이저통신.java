package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//https://head89.tistory.com/7 참조
public class Main_BJ_06087_G3_레이저통신 {
	static int X, Y, min;
	static char[][] board;
	static int[][] visited;
	static boolean[][][] check;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static Point p1, p2;

	static class Point implements Comparable<Point> {
		int y, x, dir, cnt;

		public Point(int y, int x, int dir, int cnt) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}

		public Point(){}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		board = new char[Y][X];
		check = new boolean[Y][X][Y*X];

		for (int i = 0; i < Y; i++) {
			board[i] = br.readLine().toCharArray();
		}

		init();

		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(p1);

		visited = new int[Y][X];
		for(int array[] : visited){
			Arrays.fill(array,Integer.MAX_VALUE);
		}

		int answer = 0;
		w : while(!q.isEmpty()){
			int len = q.size();

			for (int i = 0; i < len; i++) {
				Point now = q.poll();
				if(p2.y == now.y && p2.x == now.x){
					answer = now.cnt;
					break w;
				}

				for (int j = 0; j < 4; j++) {
					int ny = now.y + dy[j];
					int nx = now.x + dx[j];

					if(0<=ny && ny<Y && 0<=nx && nx<X && board[ny][nx] != '*'){

						if(now.dir != -1 && now.dir != j){
							if( visited[ny][nx] >= now.cnt+1) {
								visited[ny][nx] = now.cnt+1;
								q.add(new Point(ny, nx, j, now.cnt+1));
							}
						} else {
							if(visited[ny][nx] >= now.cnt && (now.dir == -1 || !check[ny][nx][now.cnt+j])){
								visited[ny][nx] = now.cnt;
								check[ny][nx][now.cnt+j] = true;
								q.add(new Point(ny, nx, j, now.cnt));
							}
						}
					}
				}
			}
		}

		System.out.println(answer);
	}

	static void init(){
		int cnt = 0;
		p1 = new Point();
		p2 = new Point();

		out : for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(cnt == 2) break out;
				if(board[i][j] == 'C'){
					if(cnt==0){
						p1.y= i;
						p1.x = j;
						p1.dir = -1;
						p1.cnt = 0;
						cnt++;
					} else {
						p2.y = i;
						p2.x = j;
						p2.dir = -1;
						p2.cnt = 0;
						cnt++;
					}
				}
			}
		}
	}
}
