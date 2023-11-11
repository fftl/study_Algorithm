package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_01706_S2_크로스워드 {
	static int y, x;
	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	static char[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		board = new char[y][x];
		for (int i = 0; i < y; i++) {
			char[] now = br.readLine().toCharArray();
			board[i] = now;
		}
		
		visited = new boolean[y][x];
		ArrayList<String> str = new ArrayList<>();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if(visited[i][j]) continue;
				if(board[i][j] == '#') continue;
				StringBuilder sb = new StringBuilder();
				sb.append(board[i][j]);
				
				int ny = i + dy[0];
				int nx = j + dx[0];
				while(0<=ny && ny<y && 0<=nx && nx<x && !visited[ny][nx] && board[ny][nx] != '#') {
					sb.append(board[ny][nx]);
					visited[ny][nx] = true;
					ny = ny + dy[0];
					nx = nx + dx[0];
					
				}
				if(sb.length()>1) str.add(sb.toString());
			}
		}
		
		visited = new boolean[y][x];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if(visited[i][j]) continue;
				if(board[i][j] == '#') continue;
				StringBuilder sb = new StringBuilder();
				sb.append(board[i][j]);
				
				int ny = i + dy[1];
				int nx = j + dx[1];
				while(0<=ny && ny<y && 0<=nx && nx<x && !visited[ny][nx] && board[ny][nx] != '#') {
					sb.append(board[ny][nx]);
					visited[ny][nx] = true;
					ny = ny + dy[1];
					nx = nx + dx[1];
					
				}
				if(sb.length()>1) str.add(sb.toString());
			}
		}
		
		Collections.sort(str);
		System.out.println(str.get(0));
	}
}
