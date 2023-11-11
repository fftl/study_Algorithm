package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//입력 값과 시간 제한이 애매해서, 제가 생각한 순열(모든 더러운 위치에 모든 순서로 방문하기) + bfs로 풀 수 있을지 애매했습니다.
//그래도 일단 제가 생각한 대로 구현을 해보았고, 예제의 답은 올바르게 찾아내는데 성공했습니다.
//하지만 bj사이트에 제출을 해보니 10%에서 시간초과가 나버렸고 질문 게시판을 방문하게 되었습니다.
//거기서 얻은 힌트는 (y, x)->(ny, nx)의 거리는 어차피 고정되어 있기 때문에 이 거리를 저장해 둔 뒤
//다음 탐색에서는 이 거리를 바로 가져다 사용하는 방식이었습니다.
//전혀 생각해보지 못한 방법이었고 이를 사용하니 문제를 해결할 수 있었습니다.
//근데 다른 java 풀이를 보니 저의 풀이보다 몇배는 효율적인 코드를 발견해서 공부해보기로 하였습니다.
public class Main_BJ_04991_G1_로봇청소기 {
	static int X, Y, starCnt, cnt, res;
	static int[][][][] dist;
	static char[][] board;
	static ArrayList<int[]> stars;
	static int[] start;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean impossible;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			if(X==0 && Y==0) return;
			
			dist = new int[20][20][20][20];
			
			board = new char[Y][X];
			start = new int[2];
			stars = new ArrayList<>();
			res = Integer.MAX_VALUE;
			impossible = false;
			
			for (int i = 0; i < Y; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			find();
			
			boolean[] visited = new boolean[stars.size()];
			dfs(0, 0, start[0], start[1], visited);
			
			if(impossible) System.out.println(-1);
			else System.out.println(res);
		}
	}
	
	static void dfs(int len, int cnt, int y, int x, boolean[] visited) {
		//어느 한 곳에서 다른 곳으로 이동할 수 없다면, 결국 청소가 불가능 한 것!
		if(impossible) return;
		
		//모든 곳에 방문했다면 거리를 갱신해줍니다.
		if(cnt == stars.size()) {
			res = Math.min(len, res);
			return;
		}
		
		//모든 곳에 방문 하기도 전에 이미 이전의 최소 거리를 넘었다면 중단해버립니다.
		if(len > res) return;
		
		
		for (int i = 0; i < stars.size(); i++) {
			boolean[][] root = new boolean[Y][X];
			if(visited[i]) continue;
			int[] next = stars.get(i);
			
			if(dist[y][x][next[0]][next[1]] != 0) {
				visited[i] = true;
				dfs(len+dist[y][x][next[0]][next[1]], cnt+1, next[0], next[1], visited);
				visited[i] = false;
				
			} else {
				
				Queue<int[]> q = new LinkedList<>();
				root[y][x] = true;
				q.add(new int[] {y, x});
				
				int nowLen = 0;
				boolean success = false;
				run : while(!q.isEmpty()) {
					int qSize = q.size();
					for (int j = 0; j < qSize; j++) {
						int[] now = q.poll();
						if(now[0] == next[0] && now[1] == next[1]) {
							success = true;
							break run;
						}
						
						for (int k = 0; k < 4; k++) {
							int ny = now[0] + dy[k];
							int nx = now[1] + dx[k];
							if(0<=ny && ny<Y && 0<=nx && nx<X && board[ny][nx] != 'x' && !root[ny][nx]) {
								root[ny][nx] = true;
								q.add(new int[] {ny,nx});
							}
						}
					}
					nowLen++;
				}
				
				//방문하는데 성공했다!
				if(success) {
					dist[y][x][next[0]][next[1]] = nowLen;
					dist[next[0]][next[1]][y][x] = nowLen;
					visited[i] = true;
					dfs(len+nowLen, cnt+1, next[0], next[1], visited);
					visited[i] = false;
				} else {
					impossible = true;
				}
			}
			
		}
	}
	
	static void find() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(board[i][j] == 'o') {
					start[0] = i;
					start[1] = j;
				} else if(board[i][j] == '*') {
					stars.add(new int[] {i, j});
				}
			}
		}
	}
}
