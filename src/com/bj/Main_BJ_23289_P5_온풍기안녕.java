package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_23289_P5_온풍기안녕 {
	static int Y, X, K;
	static int[][] map;
	
	static HashMap<String, Integer> wall = new HashMap<>();
	static ArrayList<Machine> m = new ArrayList<>();
	
	//바깥칸 온도 감소
	static void down() {
		for (int i = 0; i < Y; i++) if(map[i][0] > 0) map[i][0]--;
		for (int i = 0; i < Y; i++) if(map[i][X-1] > 0) map[i][0]--;
		for (int i = 1; i < X-1; i++) if(map[0][i] > 0) map[i][0]--;
		for (int i = 1; i < X-1; i++) if(map[Y-1][i] > 0) map[i][0]--;
	}
	
	static void wind(int d) {
		switch(d) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
		
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		
		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n>0 && n<5) {
					m.add(new Machine(i, j, n));
				}
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int w = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			if(t==0) {
				wall.put(y+","+(x-1), 3);
				wall.put(y+","+x, 2);
			} else {
				wall.put(y+","+x, 0);
				wall.put((y+1)+","+x, 1);
			}
		}
		
		System.out.println(wall.toString());
	}
	
	static class Machine{
		int y, x, d;
		public Machine(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Muchine [y=" + y + ", x=" + x + ", d=" + d + "]";
		}
		
	}
}
