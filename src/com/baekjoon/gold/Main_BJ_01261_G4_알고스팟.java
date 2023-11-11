package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_01261_G4_알고스팟 {
	static int N, M;
	static char[][] board;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};

	static class Node{
		int x, y, cnt;

		public Node(int y, int x, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Node{");
			sb.append("x=").append(x);
			sb.append(", y=").append(y);
			sb.append(", cnt=").append(cnt);
			sb.append('}');
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cnt-o2.cnt;
			}
		});

		boolean[][] visited = new boolean[N][M];

		pq.add(new Node(0, 0, 0));
		visited[0][0] = true;

		int res = 0;
		while(!pq.isEmpty()){
			Node node = pq.poll();
			if(node.y == N-1 && node.x == M-1){
				res = node.cnt;
			}

			for (int i = 0; i < 4; i++) {
				int ny = node.y+dy[i];
				int nx = node.x+dx[i];

				if(0<=ny && ny<N && 0<=nx && nx<M && !visited[ny][nx]){
					visited[ny][nx] = true;
					if(board[ny][nx] == '0'){
						pq.add(new Node(ny, nx, node.cnt));
					} else {
						pq.add(new Node(ny, nx, node.cnt+1));
					}
				}
			}
		}

		System.out.println(res);
	}
}
