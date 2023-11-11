package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_02636_G4_치즈 {
	static int Y, X;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	
	//끝났는지 확인! 1이 하나라도 있다면 종료 못함!
	static boolean end() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(map[i][j] == 1) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		visited = new boolean[Y][X];
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int last = 0;
		while(end()) {
			
			//매번 0을 찾는 bfs를 진행하며
			//만약 다음 갈 위치가 1일 경우에는 여기는 공기가 닿는 치즈 이므로 arr에 담아둡니다.
			//현재 갈 수 있는 0을 모두 방문했다면 공기가 닿는 치즈들은 0으로 변경해주는 것을 반복합니다.
			
			cnt++;
			ArrayList<int[]> arr = new ArrayList<>();
			Queue<int[]> q = new LinkedList<>();
			visited = new boolean[Y][X];
			
			q.add(new int[] {0,0});
			visited[0][0] = true;
			
			while(!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] now = q.poll();
					
					for (int j = 0; j < 4; j++) {
						int ny = now[0] + dy[j];
						int nx = now[1] + dx[j];
						if(0<=ny && ny<Y && 0<=nx && nx<X && !visited[ny][nx]) {
							if(map[ny][nx] == 1) {
								arr.add(new int[] {ny, nx});
							} else {
								q.add(new int[] {ny, nx});
							}
							visited[ny][nx] = true;
						}
					}
				}
			}
			
			last = arr.size();
			for (int i = 0; i < arr.size(); i++) {
				int[] now = arr.get(i);
				map[now[0]][now[1]] = 0;
			}
		}
		
		System.out.println(cnt);
		System.out.println(last);
	}
}
