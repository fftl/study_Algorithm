package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_19238_G3_스타트택시 {

	static class Node {
		int sy, sx, ey, ex;

		public Node(int sy, int sx, int ey, int ex) {
			super();
			this.sy = sy;
			this.sx = sx;
			this.ey = ey;
			this.ex = ex;
		}

		@Override
		public String toString() {
			return sy + "," + sx;
		}
	}

	static int N, M, k;
	static int[] me;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static Node[] nodes;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		me = new int[2];
		map = new int[N][N];
		nodes = new Node[M + 1];
		int cnt = M;

		//벽의 위치는 -1로 표시 아니면 0
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					map[i][j] = -1;
				else
					map[i][j] = 0;
			}
		}

		st = new StringTokenizer(br.readLine());

		me[0] = Integer.parseInt(st.nextToken()) - 1;
		me[1] = Integer.parseInt(st.nextToken()) - 1;

		//승객의 출발위치는 각 인덱스로 map에 표시해주었습니다.
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			map[sy][sx] = i;
			nodes[i] = new Node(sy, sx, ey, ex);
		}
		
		while (cnt > 0) {
			
			visited = new boolean[N][N];
			visited[me[0]][me[1]] = true;
			Queue<int[]> q = new LinkedList<>();
			PriorityQueue<Node> find = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					if (o1.sy == o2.sy) {
						return o1.sx - o2.sx;
					}
					return o1.sy - o2.sy;
				}
			});
			q.add(me);
			int len1 = 0;
			
			// bfs를 이용해서 가장 가까운 사람을 찾으러 갑니다!
			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] now = q.poll();
					
					//현재 위치에 승객이 있다면 find에 추가
					if (map[now[0]][now[1]] > 0) {
						find.add(nodes[map[now[0]][now[1]]]);
					}
					
					for (int j = 0; j < 4; j++) {
						int ny = now[0] + dy[j];
						int nx = now[1] + dx[j];
						if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx]>=0 && !visited[ny][nx]) {
							q.add(new int[] { ny, nx });
							visited[ny][nx] = true;
						}
					}
				}
				
				//이번거리에 승객이 한명이라도 있다면 중지
				if (find.size() > 0) {
					break;
				}
				len1++;
			}
			
			//모든 탐색을 했는데 승객이 없었다면 태울수 없는 위치에 있다는 것
			//-1 종료
			if (find.size() == 0) {
				System.out.println("end1");
				System.out.println(-1);
				return;
			}
			
			//승객을 태우러 이동, 이동했는데 기름이 음수가 되었다면 기름이 부족하다는 것
			//-1 종료
			k -= len1;
			if (k < 0) {
				System.out.println("end2");
				System.out.println(-1);
				return;
			}

			//가장 가까운 승객을 태우러 갑니다.
			Node nd = find.poll();
			visited = new boolean[N][N];
			visited[nd.sy][nd.sx] = true;

			Queue<int[]> go = new LinkedList<>();
			go.add(new int[] { nd.sy, nd.sx });

			int len2 = 0;
			run: while (true) {
				if(k<len2) {
					System.out.println(-1);
					return;
				}
				len2++;
				int size = go.size();
				for (int i = 0; i < size; i++) {
					int[] now = go.poll();
					for (int j = 0; j < 4; j++) {
						int ny = now[0] + dy[j];
						int nx = now[1] + dx[j];
						if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx]>=0 && !visited[ny][nx]) {
							//좌표가 해당 승객의 목적지라면 while을 종료
							if (ny == nd.ey && nx == nd.ex) {
								break run;
							}
							
							go.add(new int[] { ny, nx });
							visited[ny][nx] = true;
						}
					}
				}
			}
			
			//현재 기름으로 갈수 있다면 가고 아니라면 -1
			k -= len2;
			if (k < 0) {
				System.out.println("end3");
				System.out.println(-1);
				return;
			}
			//도착했다면 출발지~도착지 거리 *2 기름을 더해줍니다.
			k += len2 * 2;

			//출발지는 0으로 없애주고, 내 위치도 이동해줍니다.
			map[nd.sy][nd.sx] = 0;
			me[0] = nd.ey;
			me[1] = nd.ex;
			cnt--;
		}

		System.out.println(k);
	}
}
