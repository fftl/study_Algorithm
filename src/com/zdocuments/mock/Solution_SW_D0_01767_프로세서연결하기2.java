package com.zdocuments.mock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_D0_01767_프로세서연결하기2 {

	static int N, maxCnt, minLen;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> points;
	static boolean[] visitedPoints;
	
	//끝까지 도달할 수 있는지 확인
	static boolean ableCheck(int dy, int dx, int y, int x) {
		int ny = y+dy;
		int nx = x+dx;
		while(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] == 0) {
			ny += dy;
			nx += dx;
		}
		
		if(ny<0 || N<=ny || nx<0 || N<=nx) {
			return true;
		}
		
		return false;
	}
	
	//연결이 가능하면 해당 라인을 앞으로는 못가도록 합니다.
	static int lineGo(int dy, int dx, int y, int x) {
		int ny = y+dy;
		int nx = x+dx;
		int cnt = 0;
		while(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] == 0) {
			map[ny][nx] = 2;
			cnt++;
			ny += dy;
			nx += dx;
		}
		return cnt;
	}
	
	//다음 dfs를 위해서 다시 false 처리해줍니다.
	static void lineCome(int dy, int dx, int y, int x) {
		int ny = y+dy;
		int nx = x+dx;
		while(0<=ny && ny<N && 0<=nx && nx<N && map[ny][nx] == 2) {
			map[ny][nx] = 0;
			ny += dy;
			nx += dx;
		}
	}
	
	static void dfs(int idx, int y, int x, int cnt, int len, int dep) {
		visitedPoints[idx] = true;
		
		//종료
		if(dep == N-1) {
			if(maxCnt<cnt) {
				maxCnt = cnt;
				minLen = len;
			} else if(maxCnt==cnt) {
				minLen = Math.min(minLen, len);
			}
			return;
		}
		
		if(N-dep < maxCnt-cnt) {
			return;
		}
		
		
		//벽에 붙어있는 코어라면!
		if(y==0 || x==0 || y==N-1 || x==N-1) {
			for (int i = 0; i < points.size(); i++) {
				if(visitedPoints[i]) continue;
				dfs(i, points.get(i)[0], points.get(i)[1], cnt+1, len, dep+1);
			}
		} else {
			for (int i = 0; i < 4; i++) {
				if(ableCheck(dy[i], dx[i], y, x)) {
					int lineLen = lineGo(dy[i], dx[i], y, x);
					for (int j = 0; j < points.size(); j++) {
						if(visitedPoints[j]) continue;
						dfs(j, points.get(j)[0], points.get(j)[1], cnt+1, len+lineLen, dep+1);
						visitedPoints[j] = false;
					}
					lineCome(dy[i], dx[i], y, x);
				}
			}
			
			//선택하지 않고 다음 코어를 선택하는 경우
			for (int j = 0; j < points.size(); j++) {
				if(visitedPoints[j]) continue;
				dfs(j, points.get(j)[0], points.get(j)[1], cnt, len, dep+1);
				visitedPoints[j] = false;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new java.io.FileInputStream("res/sw_input_1767.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			points = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
					if(n == 1) {
						points.add(new int[] {i, j});
					}
				}
			}
			
			visitedPoints = new boolean[points.size()];
			for (int i = 0; i < points.size(); i++) {
				int y = points.get(i)[0];
				int x = points.get(i)[1];
				dfs(i, y, x, 1, 0, 0);
			}
			
			System.out.println("#"+tc+" "+minLen);
		}
	}
}