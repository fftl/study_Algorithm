package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D5_01247_최적경로 {
	
	static int[][] board;
	static int[] result, office, home;
	static boolean[] visited;
	static int N, min;
	
	static void check() {
		int y = office[0];
		int x = office[1];
		
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			int idx = result[i];
			int ny = board[idx][0];
			int nx = board[idx][1];
			
			sum += Math.abs(y-ny) + Math.abs(x-nx);
			y = ny;
			x = nx;
		}
		
		sum += Math.abs(y-home[0]) + Math.abs(x-home[1]);
		
		//계산한 거리의 값이 현재 최소값보다 작을 경우 min을 갱신해줍니다.
		min = Math.min(min, sum);
	}
	
	//순열을 이용해 고객의 집을 모두 들르는 모든 경우를 찾아서 check()를 통해서 거리를 구합니다.
	static void permu(int cnt) {
		if(cnt == N) {
			check();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			result[cnt] = i;
			permu(cnt+1);
			visited[i] = false;
		}
	}

	//저는 방문해야할 집이 최대 10개라면 순열을 이용한 완전 탐색을 해도 좋다고 생각했습니다.
	//그래서 회사, 집, 그리고 고객의 집들을 입력받은 뒤
	//고객의 집에 방문할 수 있는 방법을 순열을 이용해서 모두 찾고, 하나씩 거리를 계산해보며
	//최소값을 가지는 경로를 찾았습니다.
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_1247.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][2];
			result = new int[N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;
			
			//회사위치 구하기
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			office = new int[] {y,x};
			
			//집 위치 구하기
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home = new int[] {y,x};
			
			//각 집의 위치 구하기
			for (int i = 0; i < N; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				board[i][0] = y;
				board[i][1] = x;
			}
			
			permu(0);
			
			System.out.println("#"+tc+" "+min);
		}
	}

}
