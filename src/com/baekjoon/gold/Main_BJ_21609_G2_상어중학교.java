package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_21609_G2_상어중학교 {
	//기준블록 y, x, 레인보우개수, 좌표들
	static class Group{
		int sy, sx, rCnt;
		ArrayList<int[]> points;
		
		public Group(int sy, int sx, int rCnt, ArrayList<int[]> points) {
			this.points = points;
			this.sy = sy;
			this.sx = sx;
			this.rCnt = rCnt;
		}

		@Override
		public String toString() {
			return "Group [sy=" + sy + ", sx=" + sx + ", rCnt=" + rCnt + ", points=" + points + "]";
		}
	}

	static int N, M, maxCnt, maxNum, result;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<ArrayList<int[]>> groups;
	static ArrayList<Group> standards;
	
	//기준블록 찾기
	static void findStandard() {
		int rCnt = 0;
		
		for (int i = 0; i < groups.size(); i++) {
			int y = 20;
			int x = 20;
			
			ArrayList<int[]> now = groups.get(i);
			for (int[] n : now) {
				if(map[n[0]][n[1]] == 0) {
					rCnt++;
					continue;
				}
				
				if(y>n[0]) {
					y = n[0];
					x = n[1];
				} else if(y==n[0]) {
					if(x>n[1]) {
						y = n[0];
						x = n[1];
					}
				}
			}
//			System.out.println(y+","+x+","+rCnt);
			standards.add(new Group(y, x, rCnt, now));
			rCnt = 0;
		}
		
		//문제랑 반대??
		Collections.sort(standards, new Comparator<Group>() {

			@Override
			public int compare(Group o1, Group o2) {
				if(o1.rCnt!=o2.rCnt) {
					return (o1.rCnt-o2.rCnt)*-1;
				} else {
					if(o1.sy!=o2.sy) {
						return (o1.sy-o2.sy)*-1;
					} else {
						return (o1.sx-o2.sx)*-1;
					}
				}
			}
		});
	}
	
	//가장 큰 블록 그룹 구하기
	static void findGroup() {
		visited = new boolean[N][N];
		groups = new ArrayList<>();
		standards = new ArrayList<>();
		
		maxCnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				
				int num = map[i][j];
				if(num == -1 || num == 0 || num==-9) continue;
				int nowCnt = 0;
				ArrayList<int[]> nowGroup = new ArrayList<>();
				
				Queue<int[]> q = new LinkedList<>();
				nowGroup.add(new int[] {i,j});
				q.add(new int[] {i,j});
				visited[i][j] = true;
				
				while(!q.isEmpty()) {
					int size = q.size();
					for (int k = 0; k < size; k++) {
						nowCnt++;
						int[] now = q.poll();
						int nowy = now[0];
						int nowx = now[1];
						
						for(int l=0; l<4; l++) {
							int ny = nowy + dy[l];
							int nx = nowx + dx[l];
							
							if(0<=ny && ny<N && 0<=nx && nx<N && visited[ny][nx] == false) {
								if(map[ny][nx] == num || map[ny][nx] == 0) {
									q.add(new int[] {ny, nx});
									nowGroup.add(new int[] {ny, nx});
									visited[ny][nx] = true;
								}
							}
						}
						
					}
				}
				
				//무지개는 다시 false로 만들어줍니다.
				for (int k = 0; k < nowGroup.size(); k++) {
					int[] now = nowGroup.get(k);
					if(map[now[0]][now[1]] == 0) {
						visited[now[0]][now[1]] = false;
					}
				}
				
				if(maxCnt<nowCnt) {
					maxCnt = nowCnt;
					maxNum = num;
					groups.clear();
					groups.add(nowGroup);
				} else if(maxCnt==nowCnt) {
					groups.add(nowGroup);
				}
			}
		}
		
		findStandard();
	}
	
	static void blockDel() {
		Group g = standards.get(0);
		int cnt = g.points.size();
		result += cnt*cnt;
		
		for (int i = 0; i < g.points.size(); i++) {
			int[] now = g.points.get(i);
			
			map[now[0]][now[1]] = -9;
		}
	}
	
	//내려주기
	static void gravity() {
		for (int i = 0; i < N; i++) {
			int high = N-1;
			for (int j = N-1; j >= 0; j--) {
				if(map[j][i] == -9) continue;
				if(map[j][i] >= 0) {
					if(high == j) {
						high -= 1;
						continue;
					}
					
					map[high][i] = map[j][i];
					map[j][i] = -9;
					high -= 1;
				} else {
					high = j-1;
				}
			}
		}
	}
	
	//돌리기
	static void rotate() {
		int[][] copy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[j][i] = map[i][N-1-j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = copy[i][j];
			}
		}
		
		
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
//			System.out.println("-------------------------------");
			findGroup();
			if(maxCnt == 1) break;
			blockDel();
			gravity();
			rotate();
			gravity();
//			System.out.println(Arrays.deepToString(map));
		}
		
		System.out.println(result);
	}
}


