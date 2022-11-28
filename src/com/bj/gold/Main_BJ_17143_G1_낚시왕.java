package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_17143_G1_낚시왕 {
	static class Shark{
		int y, x, s, d, z;

		public Shark(int y, int x, int s, int d, int z) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "shark [y=" + y + ", x=" + x + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}
		
	}
	
	static int Y, X, M, result;
	static int[][] map;
	static int[] dy = {0, -1, 1, 0, 0};
	static int[] dx = {0, 0, 0, 1, -1};
	static List<List<List<Shark>>> list; 
	
	//상어잡기!
	static void fishing(int n) {
		for (int i = 0; i < Y; i++) {
			if(list.get(i).get(n).size()!=0) {
				Shark s = list.get(i).get(n).get(0);
				result += s.z;
				list.get(i).get(n).remove(s);
				break;
			}
		}
	}
	
	static void eat() {
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(list.get(i).get(j).size()>1) {
					list.get(i).get(j).sort(new Comparator<Shark>() {
						@Override
						public int compare(Shark o1, Shark o2) {
							// TODO Auto-generated method stub
							return o2.z-o1.z;
						}
					});
					Shark s = list.get(i).get(j).get(0);
					list.get(i).get(j).clear();
					list.get(i).get(j).add(s);
				}
			}
		}
		
	}
	
	static void moving() {
		ArrayList<Shark> moved = new ArrayList<>();
		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				if(list.get(i).get(j).size()!=0) {
					Shark s = list.get(i).get(j).get(0);
					int y = s.y;
					int x = s.x;
					int ns = 0;
					
					if(s.d<=2) ns = s.s%(Y*2-2);
					else ns = s.s%(X*2-2);
					
					for (int k = 0; k < ns; k++) {
						int ny = y+dy[s.d];
						int nx = x+dx[s.d];
						
						if(0<=ny && ny<Y && 0<=nx && nx<X) {
							y = ny;
							x = nx;
						} else {
							int nowD = s.d;
							if(nowD==1) s.d=2;
							else if(nowD==2) s.d=1;
							else if(nowD==3) s.d=4;
							else if(nowD==4) s.d=3;
							
							y = y+dy[s.d];
							x = x+dx[s.d];
						}
					}
					
					s.y = y;
					s.x = x;
					
					list.get(i).get(j).remove(s);
					moved.add(s);
				}
			}
		}
		
		for (int i = 0; i < moved.size(); i++) {
			Shark s = moved.get(i);
			list.get(s.y).get(s.x).add(s);
		}
		
	}
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(M==0) {
			System.out.println(0);
			return;
		}
		
		map = new int[Y][X];
		list = new ArrayList<>();
		for (int i = 0; i < Y; i++) {
			list.add(new ArrayList<>());
			for (int j = 0; j < X; j++) {
				list.get(i).add(new ArrayList<>());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			list.get(y-1).get(x-1).add(new Shark(y-1,x-1,s,d,z));
		}
		
		for (int i = 0; i < X; i++) {
			fishing(i);
			moving();
			eat();
		}
		
		System.out.println(result);
	}
}


		 
