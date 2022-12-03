package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17472_G1_다리만들기 {
	
	static class Node{
		int s, e, k;

		public Node(int s, int e, int k) {
			super();
			this.s = s;
			this.e = e;
			this.k = k;
		}

		@Override
		public String toString() {
			return s + " " + e + " / " + k +"\n";
		}
		
	}

	static int Y, X, landCnt;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[] parents;
	static int[][] map;
	static ArrayList<Node> cons = new ArrayList<>();
	
	static void find() {
		int p = 2;
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(map[i][j] == 1) {
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i, j});
					
					while(!q.isEmpty()) {
						int[] now = q.poll();
						map[now[0]][now[1]] = p;
						for (int k = 0; k < 4; k++) {
							int ny = now[0] + dy[k];
							int nx = now[1] + dx[k];
							
							if(0<=ny && ny<Y && 0<=nx && nx<X && map[ny][nx] == 1) {
								q.add(new int[] {ny, nx});
							}
						}
						
					}
					landCnt++;
					p++;
				} 
			}
		}
	}
	
	static void connect(int y, int x) {
		int nowp = map[y][x];
		
		for (int i = 0; i < 4; i++) {
			int ny =y;
			int nx =x;
			int cnt = 0;
			while(0<=ny && ny<Y && 0<=nx && nx<X) {
				if(ny == y && nx == x) {
					ny += dy[i];
					nx += dx[i];
					continue;
				}
				
				cnt++;
				if(map[ny][nx] == 0) {
					ny += dy[i];
					nx += dx[i];
					
				} else if(map[ny][nx] != nowp) {
					if(cnt > 2) {
						cons.add(new Node(nowp, map[ny][nx], cnt-1));
					}
					break;
				} else {
					
					break;
				}
			}
		}
	}
	
	//---------------------------------- kruskal
	static void make() {	//크기가 1인 서로 소 집합 생성
		
		parents = new int[landCnt];
		for (int i = 0; i < landCnt; i++) {	// 모든 노드가 자신을 부모로하는(대표자) 집합으로 만듦
			parents[i] = i;
		}
	}
	
	static int find(int a) { //a의 대표자 찾기
		if(parents[a] == a) {	//나의 부모가 나라면
			return a;
		}
		
		return parents[a] = find(parents[a]);	//우리의 대표자를 나의 부모로.. :path compression
	}
	
	static boolean union(int a, int b) { // 리턴값 : true ==> union 성공, 
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false; //이미 두 집합은 같은 집합이다.
		
		parents[bRoot] = aRoot;
		return true;
		
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		landCnt = 0;
		
		map = new int[Y][X];
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find();
		
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(map[i][j]>0) {
					connect(i, j);
				}
			}
		}
		
		Collections.sort(cons, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.k-o2.k;
			}
		});
		
		make();
		
		int result = 0;
		int count = 0;
		for(Node node : cons) {
			if(union(node.s-2, node.e-2)) {
				result += node.k;
				if(++count == landCnt) break;
			}
		}

		for (int i = 0; i < parents.length; i++) {
			find(i);
		}
		
		int n=parents[0];
		for (int i = 1; i < parents.length; i++) {
			if(parents[i] != n) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		
		System.out.println(result);
	}
}



