package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_05014_S1_스타트링크 {
	static int F;	//건물 최고층
	static int S;	//출발
	static int G;	//목표
	static int U;	//올라가는 크기
	static int D;	//내려가는 크기
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		if(S==G) {
			System.out.println(0);
			return;
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[F+1];
		
		q.add(S);
		visited[S] = true;
		
		int cnt = 1;
		w : while(!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				int now = q.poll();
				//올라가보자!
				int nextU = now+U;
				if(nextU <= F && !visited[nextU]) {
					if(nextU == G) {
						visited[G] = true;
						break w;
					} else {
						visited[nextU] = true;
						q.add(nextU);
					}
				}
				
				//내려가보자!
				int nextD = now-D;
				if(nextD>=1 && !visited[nextD]) {
					if(nextD == G) {
						visited[G] = true;
						break w;
					} else {
						visited[nextD] = true;
						q.add(nextD);
					}
				}
			}
			
			cnt++;
		}
		
		if(visited[G]) System.out.println(cnt);
		else System.out.println("use the stairs");
	}
}
