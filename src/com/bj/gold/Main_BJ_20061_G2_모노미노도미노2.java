package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_20061_G2_모노미노도미노2 {
	
	static boolean[][] blue, green;
	
	static void moveBlue(int t, int y, int x) {
		ArrayList<int[]> point = new ArrayList<>();
		point.add(new int[] {y, x});
		
		if(t == 1) {
		} else if(t == 2) {
		} else if(t == 3) {
			point.add(new int[] {y+1, x});
		}
		
	}
	
	static void moveGreen(int t, int y, int x) {
		if(t == 1) {
			
		} else if(t == 2) {
			
		} else if(t == 3) {
			
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		blue = new boolean[4][10];
		green = new boolean[10][4];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			//1 => 1x1
			//2 => 1x2 y,x / y,x+1
			//3 => 1x2 y,x / y+1,x
			moveBlue(t, y, x);
			moveGreen(t, y, x);
			
			
		}
	}
}
