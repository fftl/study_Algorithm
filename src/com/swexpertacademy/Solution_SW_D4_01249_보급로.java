package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_SW_D4_01249_보급로 {
	//크기와 좌표를 가지고 있는 노드를 만들어주었습니다
	static class Node{
		int y, x, k;

		public Node(int y, int x, int k) {
			super();
			this.y = y;
			this.x = x;
			this.k = k;
		}

		@Override
		public String toString() {
			return y + "," + x + " / "+ k;
		}
		
	}
	static int N, min;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map, size;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_1249.txt")); // input 가져오기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#"+tc+" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			size = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String now = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = now.charAt(j) -'0';
					size[i][j] = Integer.MAX_VALUE;
				}
			}
			
			min = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			visited[0][0] = true;
			
			//우선순위큐를 이용해서 가중치가 작은 순으로 정렬하여 가장 작은것 부터 이동할 수 있도록 합니다.
			PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.k-o2.k;
				}
			});
			
			pq.add(new Node(0, 0, map[0][0]));
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				for (int i = 0; i < 4; i++) {
					int ny = node.y+dy[i];
					int nx = node.x+dx[i];
					if(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx] && size[ny][nx] >(map[ny][nx] + node.k)) {
						size[ny][nx] = map[ny][nx] + node.k;
						visited[ny][nx] = true;
						pq.add(new Node(ny, nx, size[ny][nx]));
					}
				}
			}
			
			System.out.println(size[N-1][N-1]);
		}
	}

}
