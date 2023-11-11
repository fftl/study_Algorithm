package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_23290_G1_마법사상어와복제 {
	static int N, M, S, sy, sx, eCnt;
	static String root;
	static int[] fy = {0, -1, 0, 1, 0};
	static int[] fx = {0, 0, -1, 0, 1};

	static int[] ey = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] ex = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static boolean[][] map;
	static int[][] fmap;
	
	static ArrayList<Fish> fishes = new ArrayList<>();
	static ArrayList<Fish> copys = new ArrayList<>();
	static ArrayList<Smell> smells = new ArrayList<>();

	//2
	static void fMove() {
		for (int i = 0; i < fishes.size(); i++) {
			Fish f = fishes.get(i);
			//원래 방향으로 갈 수 있다면,
			for (int j = 0; j < 9; j++) {
				int nd = (f.d+9-j) % 9;
				int ny = f.y + ey[nd];
				int nx = f.x + ex[nd];
				if(ny == f.y && nx == f.x) continue;
				
				//갈 수 있는 상황이라면 바로 이동합니다.
				if(0<ny && ny<=4 && 0<nx && nx<=4 && !map[ny][nx]) {
					f.y = ny;
					f.x = nx;
					f.d = nd;
					break;
				}
			}
			fmap[f.y][f.x] += 1;
		}
	}
	
	//3
	static void sMove(int y, int x, int k, int e, boolean[][] visited, String r) {
		visited[y][x] = true;
		if(k == 3) {
			if(root.equals("")) root = r;
			if(e>eCnt) {
				root = r;
				eCnt = e;
			}
			visited[y][x] = false;
			return;
		}
		
		for (int i = 1; i <= 4; i++) {
			int ny = y + fy[i];
			int nx = x + fx[i];
			
			if(0<ny && ny<=4 && 0<nx && nx<=4 && !visited[ny][nx]) {
				if(fmap[ny][nx] > 0) sMove(ny, nx, k+1, e+fmap[ny][nx], visited, r+i);
				else sMove(ny, nx, k+1, e, visited, r+i);
			}
		}
		
		visited[y][x] = false;
	}
	
	//이동 경로에 있는 물고기를 제거하고
	//물고기가 존재하던 위치에 smell을 남깁니다.
	static void sEat() {
		ArrayList<Fish> delList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			int n = root.charAt(i)-'0';
			int ny = sy + fy[n];
			int nx = sx + fx[n];
			
			if(fmap[ny][nx] > 0) {
				smells.add(new Smell(ny, nx, 3));
				for (int j = 0; j < fishes.size(); j++) {
					Fish f = fishes.get(j);
					if(f.y == ny && f.x == nx) {
						delList.add(f);
					}
				}
			}
			
			sy = ny;
			sx = nx;
		}
		
		for(Fish f : delList) {
			fishes.remove(f);
		}
	}
	
	static void smellGo() {
		ArrayList<Smell> delList = new ArrayList<>();
		for (int i = 0; i < smells.size(); i++) {
			Smell s = smells.get(i);
			s.c = s.c-1;
			if(s.c == 0) delList.add(s);
		}
		
		for(Smell s : delList) smells.remove(s);
		
		map = new boolean[4+1][4+1];
		for (int i = 0; i < smells.size(); i++) {
			Smell s = smells.get(i);
			map[s.y][s.x] = true;
		}
	}
	
	static void fCopy() {
		for (int i = 0; i < copys.size(); i++) {
			Fish f = copys.get(i);
			fishes.add(new Fish(f.y, f.x, f.d));
		}
		
		copys.clear();
	}
	
	static void makeCopy() {
		for (int i = 0; i < fishes.size(); i++) {
			Fish f = fishes.get(i);
			copys.add(new Fish(f.y, f.x, f.d));
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = 4;
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new boolean[4+1][4+1];
		
		//물고기 정보 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ny = Integer.parseInt(st.nextToken());
			int nx = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fishes.add(new Fish(ny, nx, d));
			copys.add(new Fish(ny, nx, d));
		}
		
		//상어 정보 받기
		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < S; i++) {
			map[sy][sx] = true;
			fmap = new int[4+1][4+1];
			
			fMove();
			boolean[][] visited = new boolean[4+1][4+1];
			eCnt = 0;
			root = "";
			sMove(sy, sx, 0, 0, visited, "");
			sEat();
			smellGo();
			fCopy();
			makeCopy();
		}
		
		System.out.println(fishes.size());
	}
	
	
	
	
	
	
	
	
	
	
	//---------------------------------------------------------------------------------
	//---------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	static class Fish{
		int y, x, d;
		public Fish(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		@Override
		public String toString() {
			return y +  ", " + x + " > " + d + " / ";
		}
	}
	
	static class Smell{
		int y, x, c;
		public Smell(int y, int x, int c) {
			super();
			this.y = y;
			this.x = x;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Smell [y=" + y + ", x=" + x + ", c=" + c + "]";
		}
	}
}
