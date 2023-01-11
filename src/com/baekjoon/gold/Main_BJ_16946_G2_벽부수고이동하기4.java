package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16946_G2_벽부수고이동하기4 {
	static int N, M;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int[][] arr, result;
	static HashMap<Integer, Integer> map;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		result = new int[N][M];
		map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String[] strs = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		int idx = 1;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j});
					
					while(!q.isEmpty()) {
						cnt++;
						int[] now = q.poll();
						
						for(int k=0; k<4; k++) {
							int ny = now[0] + dy[k];
							int nx = now[1] + dx[k];
							
							if(0<=ny && ny<N && 0<=nx && nx<M && arr[ny][nx] == 0) {
								q.add(new int[] {ny, nx});
								arr[i][j] = idx;
							}
						}
					}
					
					map.put(idx, cnt);
					idx++;
					cnt=0;
				}
			}
		}
		
		System.out.println(map.toString());
		
//		visited = new boolean[N][M];
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if(arr[i][j] == 1) {
//					int cnt = 1;
//					
//					Queue<int[]> q = new LinkedList<>();
//					q.add(new int[] {i, j});
//					
//					visited[i][j] = true;
//					
//					while(!q.isEmpty()) {
//						int[] now = q.poll();
//						
//						for(int k=0; k<4; k++) {
//							int ny = now[0] + dy[k];
//							int nx = now[1] + dx[k];
//							
//							if(0<=ny && ny<N && 0<=nx && nx<M && !visited[ny][nx] && arr[ny][nx] == 0) {
//								q.add(new int[] {ny, nx});
//								visited[ny][nx] = true;
//								cnt++;
//							}
//						}
//					}
//					result[i][j] = cnt;
//					for (int k = 0; k < N; k++) {
//						Arrays.fill(visited[k], false);
//					}
//				}
//			}
//		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
