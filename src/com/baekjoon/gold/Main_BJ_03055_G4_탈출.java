package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_03055_G4_탈출 {

	static int Y, X;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[] bber, dochi;
	static char[][] map;

	static int[] dochiPath(int y, int x) {
		Queue<String[]> doc = new LinkedList<>();
		boolean[][] visited = new boolean[Y][X];
		doc.add(new String[] { Integer.toString(dochi[0]), Integer.toString(dochi[1]), "" });
		visited[dochi[0]][dochi[1]] = true;

		while (!doc.isEmpty()) {
			int size = doc.size();
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				String[] now = doc.poll();
				int ay = Integer.parseInt(now[0]);
				int ax = Integer.parseInt(now[1]);
				
				if(ay == bber[0] && ax == bber[1]) {
					System.out.println("end");
					String[] paths = now[2].split("/");
					String[] path = paths[0].split(",");
					return new int[] {Integer.parseInt(path[0]),Integer.parseInt(path[0])};
				}
				
				for (int j = 0; j < 4; j++) {
					int ny = ay + dy[j];
					int nx = ax + dx[j];
					if (0 <= ny && ny < Y && 0 <= nx && nx < X && map[ny][nx] == '.' && !visited[ny][nx]) {
						visited[ny][nx] = true;
						System.out.println(ny+","+nx);
						doc.add(new String[] {Integer.toString(ny), Integer.toString(nx), now[2]+ny+","+nx+"/" });
					}
				}
			}
		}
		
		return null;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new char[Y][X];
		dochi = new int[2];
		bber = new int[2];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < Y; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'S') {
					dochi[0] = i;
					dochi[1] = j;
				}
				
				if(map[i][j] == 'D') {
					bber[0] = i;
					bber[1] = j;
				}
				
				if(map[i][j] == '*') {
					q.add(new int[] {i,j});
				}
			}
		}

		System.out.println(Arrays.deepToString(map));
		int result = 0;
		int t = 0;
		while(!q.isEmpty()) {
			System.out.println("=------------------------------------=");
			int size=q.size();
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
					if(0<=ny && ny<Y && 0<=nx && nx<X && map[ny][nx] == '.') {
						map[ny][nx] = '*';
						q.add(new int[] {ny,nx});
					}
				}//for j
			}//for i
			
			int[] next = dochiPath(dochi[0], dochi[1]);
			System.out.println(Arrays.toString(next));
			if(next[0] == bber[0] && next[1] == bber[1]) {
				result = t;
				break;
			} else {
				dochi[0] = next[0];
				dochi[1] = next[1];
			}
			t++;
		}//while q
		
		if(result == 0) System.out.println("KAKTUS");
		else System.out.println(result);
	}
}
