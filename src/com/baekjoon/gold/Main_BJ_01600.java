package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
1
5 5
0 1 1 0 0 
0 1 1 0 0 
0 0 1 0 0 
0 1 1 1 0 
0 1 1 0 0

==> 8?
*/
public class Main_BJ_01600_G3_말이되고싶은원숭이 {
	
	static int K, Y, X;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static boolean[][][] v;
	
	static class Node{
		int y, x, k;

		public Node(int y, int x, int k) {
			super();
			this.y = y;
			this.x = x;
			this.k = k;
		}

		@Override
		public String toString() {
			return y + "," + x + "/" + k;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		v = new boolean[Y][X][k+1];
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(0, 0, 0));
		v[0][0][0] = true;
		
		int dep = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node now = q.poll();
//				System.out.println(now.toString());
				
				if(now.y==Y-1 && now.x==X-1) {
					System.out.println(dep);
					return;
				}
				
				for (int j = 0; j < 4; j++) {
					int ny = now.y +dy[j];
					int nx = now.x +dx[j];
					if(0<=ny && ny<Y && 0<=nx && nx<X && map[ny][nx] == 0 && !v[ny][nx][now.k]) {
						v[ny][nx][now.k] = true;
						q.add(new Node(ny, nx, now.k));
					}
				}
				
				if(now.k<k){
					for (int j = 0; j < 8; j++) {
						int ny = now.y +hy[j];
						int nx = now.x +hx[j];
						if(0<=ny && ny<Y && 0<=nx && nx<X && map[ny][nx] == 0 && !v[ny][nx][now.k+1]) {
							v[ny][nx][now.k+1] = true;
							q.add(new Node(ny, nx, now.k+1));
						}
					}
				}
			}
//			System.out.println("--------------------------------------");
			dep++;
		}
		
		
		System.out.println(-1);
	}
}
