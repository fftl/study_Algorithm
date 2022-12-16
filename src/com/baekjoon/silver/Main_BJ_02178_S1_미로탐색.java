package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_02178_S1_미로탐색 {
	
	static int Y, X;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] board; 

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		board = new char[Y][X];
		
		for (int i = 0; i < Y; i++) {
			char[] now = br.readLine().toCharArray();
			board[i] = now;
		}
		
		boolean[][] visited = new boolean[Y][X];
		Queue<int[]> q = new LinkedList<>();
		
		visited[0][0] = true;
		q.add(new int[] {0,0});
		
		int depth = 0;
		run : while(!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				
				//목적지에 도착했다면 종료!
				if(now[0] == Y-1 && now[1] == X-1) {
					break run;
				}
				
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
					if(0<=ny && ny<Y && 0<=nx && nx<X) {
						if(board[ny][nx] == '1' && !visited[ny][nx]) {
							visited[ny][nx] = true;
							q.add(new int[] {ny, nx});
						}
					}
				}
			}
			
			depth++;
		}
		
		System.out.println(depth+1);
	}
}
