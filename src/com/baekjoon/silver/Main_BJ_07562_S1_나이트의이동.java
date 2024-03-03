package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_07562_S1_나이트의이동 {
	static int N;
	static int[] start, end;

	//나이트가 이동할 수 있는 여덟 개의 방향을 표현.
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			N = Integer.parseInt(br.readLine());

			//시작 좌표.
			st = new StringTokenizer(br.readLine());
			start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

			//종료 좌표.
			st = new StringTokenizer(br.readLine());
			end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

			visited = new boolean[N][N];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[]{start[0], start[1]});
			visited[start[0]][start[1]] = true;

			int cnt = 1;
			boolean stop = false;
			while(!q.isEmpty()){
				//한 번에 들어있는 q의 size는 모두 같은 이동횟수로 볼수 있음.
				int size = q.size();

				outside : for (int j = 0; j < size; j++) {
					int[] now = q.poll();

					for (int k = 0; k < 8; k++) {
						int ny = now[0] + dy[k];
						int nx = now[1] + dx[k];

						//맵에서 벗어나지 않으며, 아직 방문한 적이 없는 곳이라면 확인을 시작.
						if(0<=ny && ny<N && 0<=nx && nx<N && !visited[ny][nx]){
							if(ny==end[0] && nx==end[1]) {
								stop = true;
								break outside;
							}

							//현재 좌표에 도착하는데 가장 적은 횟수로 도착할 수 있는 것은 지금 뿐
							//더 큰 이동 횟수로 이 곳에 오는 것은 쓸모가 없으므로 방문처리 해 줌.
							visited[ny][nx] = true;
							q.add(new int[]{ny, nx});

						}
					}
				}

				if(stop) break;
				cnt++;
			}

			if(!stop) sb.append(0+"\n");
			else sb.append(cnt+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
