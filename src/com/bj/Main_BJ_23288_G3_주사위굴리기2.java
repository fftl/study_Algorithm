package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_23288_G3_주사위굴리기2 {
	
	static int Y, X, K, y, x, d;
	static int[] dice;
	static int[] dy = {0, 0, 1, -1}; //동서남북
	static int[] dx = {1, -1, 0, 0}; //동서남북
	static int[][] map;
	
	static void roll(int k) {
		int[] copy = new int[6+1];
		switch(k) {
		case 0: //동
			copy[1] = dice[3];
			copy[2] = dice[2];
			copy[3] = dice[6];
			copy[4] = dice[1];
			copy[5] = dice[5];
			copy[6] = dice[4];
			break;
		case 1: //서
			copy[1] = dice[4];
			copy[2] = dice[2];
			copy[3] = dice[1];
			copy[4] = dice[6];
			copy[5] = dice[5];
			copy[6] = dice[3];
			break;
		case 2: //남
			copy[1] = dice[5];
			copy[2] = dice[1];
			copy[3] = dice[3];
			copy[4] = dice[4];
			copy[5] = dice[6];
			copy[6] = dice[2];
			break;
		case 3: //북
			copy[1] = dice[2];
			copy[2] = dice[6];
			copy[3] = dice[3];
			copy[4] = dice[4];
			copy[5] = dice[1];
			copy[6] = dice[5];
			break;
		}
		
		dice = copy;
	}
	
	static int bfs() {
//		System.out.println("bfs ----------------------------");
		boolean[][] visited = new boolean[Y+1][X+1];
		Queue<int[]> q = new LinkedList<>();
		int val = map[y][x];
		int cnt = 1;
//		System.out.println("바닥숫자 >> "+val);
		
		visited[y][x] = true;
		q.add(new int[] {y, x});
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] now = q.poll();
//				System.out.println(now[0]+","+now[1]);
				for (int j = 0; j < 4; j++) {
					int ny = now[0] + dy[j];
					int nx = now[1] + dx[j];
//					System.out.println("갈수있나? >> "+ny+","+nx);
					if(0<ny && ny<=Y && 0<nx && nx<=X && !visited[ny][nx] && map[ny][nx] == val) {
//						System.out.println("갈수있다! >> "+ny+","+nx);
						q.add(new int[] {ny, nx});
						visited[ny][nx] = true;
						cnt++;
					}
				}
				
			}
		}
		
		
		return cnt*val;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X= Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		y = 1;
		x = 1;
		int k = 0;
		int result = 0;
		
		map = new int[Y+1][X+1];
		dice = new int[] {0, 6,2,3,4,5,1};
		
		for (int i = 1; i <= Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= X; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(K>0) {
//			System.out.println("-------------------------");
			int ny = y+dy[k];
			int nx = x+dx[k];
			//가야할 방향으로 갈 수 있다면
			if(0<ny && ny<=Y && 0<nx && nx<=X) {
				roll(k);
			} else {
				//갈수 없는 경우의 중간방향도 바꾸어 줘야 한다..?
				switch(k) {
				case 0:
					k = 1;
					roll(1);
					ny = y+dy[1];
					nx = x+dx[1];
					break;
				case 1:
					k = 0;
					roll(0);
					ny = y+dy[0];
					nx = x+dx[0];
					break;
				case 2:
					k = 3;
					roll(3);
					ny = y+dy[3];
					nx = x+dx[3];
					break;
				case 3:
					k = 2;
					roll(2);
					ny = y+dy[2];
					nx = x+dx[2];
					break;
				}
			}
			y = ny;
			x = nx;
			
			result += bfs();
			
			int a = dice[1];
			int b = map[y][x];
//			System.out.println("주사위 상태 >>" + Arrays.toString(dice));
//			System.out.println("주사위바닥 >> "+ a);
//			System.out.println("주사위 위치 >> "+ y+","+x);
//			System.out.println("바닥숫자 >> "+ b);
			
			if(a>b) {
				if(k==0) {
					k = 2;
				} else if (k==1) {
					k = 3;
				} else if (k==2) {
					k = 1;
				} else {
					k = 0;
				}
			} else if(a<b) {
				if(k==0) {
					k = 3;
				} else if (k==1) {
					k = 2;
				} else if (k==2) {
					k = 0;
				} else {
					k = 1;
				}
			}
			
//			System.out.println("주사위방향 >> "+k);
			K--;
		}
		
		System.out.println(result);
	}
}
