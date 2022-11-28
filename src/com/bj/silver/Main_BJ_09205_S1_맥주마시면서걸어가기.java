package com.bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_09205_S1_맥주마시면서걸어가기 {

	static ArrayList<int[]> list;
	static int n, sy, sx, ey, ex;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(i==0) {
					sy = y;
					sx = x;
					
				} else if(i==n+1) {
					ey = y;
					ex = x;
					
				} else {
					list.add(new int[]{y,x});
				}
			}
			
			if(bfs()) System.out.println("happy");
			else System.out.println("sad");
			
		}
	}
	
	static boolean bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		q.add(new int[] {sy,sx});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(Math.abs(now[0]-ey) + Math.abs(now[1]-ex) <= 1000) {
				return true;
			}
			
			for(int i=0; i<n; i++) {
				if(!visited[i]) {
					int ny = list.get(i)[0];
					int nx = list.get(i)[1];
					
					int dis = Math.abs(now[0] - ny) + Math.abs(now[1] - nx);
					if(dis <= 1000) {
						visited[i] = true;
						q.add(new int[]{ny,nx});
					}
				}
			}
		}
		
		return false;
	}
	
}

/*
1
2
0 0
-1000 0
1000 0
2000 0
*/