package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_03190_G4_뱀 {
	static int N, K, L, direct, s; //direct - 방향, s - 시간
	static boolean[][] apple;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static Queue<Node> que;
	static Node head;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		apple = new boolean[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			apple[y][x] = true;
		}

		L = Integer.parseInt(br.readLine());
		que = new LinkedList<>();
		head = new Node(0, 0);
		que.add(head);
		direct = 0;
		s = 0;
		boolean end = false;
		
		runFor: for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			
			while(s<r) {
				int ny = head.y+dy[direct];
				int nx = head.x+dx[direct];
				s++;
				
				//벽 안으로 이동한다면
				if(0<=ny && ny<N && 0<=nx && nx<N) {
					//내 몸에 부딪힌다면
					if(que.contains(new Node(ny, nx))) {
						System.out.println("me1");
						end = true;
						break runFor;
					}
					
					que.add(new Node(ny, nx));
					head = new Node(ny, nx);
					
					if(apple[ny][nx]) {
						apple[ny][nx] = false;
					} else {
						que.poll();
					}
					
				} else {
					end = true;
					break runFor;
				}
				
				System.out.println(head.toString());
			}
			
			if(d == 'D') {
				if(direct < 3) direct++;
				else direct = 0;
			} else {
				if(direct > 0) direct--;
				else direct = 3;
			}
			
		}
		
		while(!end) {
			int ny = head.y+dy[direct];
			int nx = head.x+dx[direct];
			s++;
			
			//벽 안으로 이동한다면
			if(0<=ny && ny<N && 0<=nx && nx<N) {
				//내 몸에 부딪힌다면
				if(que.contains(new Node(ny, nx))) break;
				
				que.add(new Node(ny, nx));
				head = new Node(ny, nx);
				
				if(apple[ny][nx]) {
					apple[ny][nx] = false;
				} else {
					que.poll();
				}
				
			} else {
				break;
			}
			System.out.println(head.toString());
			
		}
		System.out.println(s);
	}
	
	static class Node{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}
		
	}
}
