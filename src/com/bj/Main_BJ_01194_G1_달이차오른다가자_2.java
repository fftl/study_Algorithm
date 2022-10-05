package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_01194_G1_달이차오른다가자_2 { //dfs -> bfs sol
	static int Y, X, min;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static char[][] map;
	static boolean[][][] visited;
	
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		map = new char[Y][X];
		visited = new boolean[Y][X][64];
		
		for (int i = 0; i < Y; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(map[i][j] == '0') {
					int dep = 0;
					
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j, 0});
					visited[i][j][0] = true;
					
					while(!q.isEmpty()) {
						int size = q.size();
						for (int w = 0; w < size; w++) {
							int[] now = q.poll();
							int y = now[0];
							int x = now[1];
							int k = now[2];
							
							if(map[y][x] == '1') {
								System.out.println(dep);
								System.exit(0);
							}
							
							for (int e = 0; e < 4; e++) {
								int ny = y+dy[e];
								int nx = x+dx[e];
								
								if(0<=ny && ny<Y && 0<=nx && nx<X && map[ny][nx] != '#' 
										&& !visited[ny][nx][k] ) {
									if(map[ny][nx] == '.' || map[ny][nx] == '1' || map[ny][nx] == '0') {
										visited[ny][nx][k] = true;
										q.add(new int[] {ny, nx, k});
										
									} else if(0 <= map[ny][nx]-'A' && map[ny][nx]-'A' <= 5) { // 문이라면!?
										int door = map[ny][nx]-'A';
										int a = 1<<door;
										if((k & a) == a) {	//근데 키가 있다면!?
											visited[ny][nx][k] = true;
											q.add(new int[] {ny, nx, k});
										}
										
									} else if(96 < map[ny][nx] && map[ny][nx]<103) {
										int nkey = map[ny][nx]-'a';
										int a = 1<<nkey;
										visited[ny][nx][k|a] = true;
										q.add(new int[] {ny, nx, k|a});
									}
								}
							}
							
						}
						dep++;
					}
					
	
				}
			}
		}
		
		System.out.println(-1);
	}
}
