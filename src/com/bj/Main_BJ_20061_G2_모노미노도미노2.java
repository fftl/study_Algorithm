package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_20061_G2_모노미노도미노2 {

	static int score, bx, by, gx, gy;
	static ArrayList<int[]> main, blue, green;
	
	static void goBlue(int t, int y, int x) {
		int[] yline = blue.get(y); 
		int[] yline2 = null;
		if(t==3) yline2 = blue.get(y+1);
		switch(t) {
		case 1:
			for (int i = 0; i < bx; i++) {
				if(yline[i] != 0) {
					yline[i-1] = 1;
					break;
				}
				if(i==bx-1) {
					yline[bx-1] = 1;
				}
			}
			break;
		case 2:
			for (int i = 0; i < bx; i++) {
				if(yline[i] != 0) {
					yline[i-1] = 1;
					yline[i-2] = 1;
					break;
				}
				if(i==bx-1) {
					yline[bx-1] = 1;
					yline[bx-2] = 1;
				}
			}
			break;
		case 3:
			for (int i = 0; i < bx; i++) {
				if(yline[i] != 0 || yline2[i] != 0) {
					yline[i-1] = 1;
					yline2[i-1] = 1;
					break;
				}
				
				if(i==bx-1) {
					yline[bx-1] = 1;
					yline2[bx-1] = 1;
				}
			}
			break;
		}
	}
	
	static void goGreen(int t, int y, int x) {
		switch(t) {
		case 1:
			for(int i=0; i<gy; i++) {
				if(green.get(i)[x] != 0) {
					green.get(i-1)[x] = 1;
					break;
				}
				
				if(i==gy-1) {
					green.get(gy-1)[x] = 1;
				}
			}
			break;
		case 2:
			for(int i=0; i<gy; i++) {
			if(green.get(i)[x] != 0 || green.get(i)[x+1] != 0) {
				green.get(i-1)[x] = 1;
				green.get(i-1)[x+1] = 1;
				break;
			}
			
			if(i==gy-1) {
				green.get(gy-1)[x] = 1;
				green.get(gy-1)[x+1] = 1;
			}
			}
			break;
		case 3:
			for(int i=0; i<gy; i++) {
			if(green.get(i)[x] != 0) {
				green.get(i-1)[x] = 1;
				green.get(i-2)[x] = 1;
				break;
			}
			
			if(i==gy-1) {
				green.get(gy-1)[x] = 1;
				green.get(gy-2)[x] = 1;
			}
			}
			break;
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		by = 4; bx = 6; gy = 6; gx = 4;
		
		blue = new ArrayList<>();
		green = new ArrayList<>();
		
		//각 생상보드 초기화
		for (int i = 0; i < by; i++) {
			blue.add(new int[bx]);
		}
		
		for (int i = 0; i < gy; i++) {
			green.add(new int[gx]);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			switch(t) {
			case 1:
				goBlue(t, y, x);
				goGreen(t, y, x);
				break;
			case 2:
				goBlue(t, y, x);
				goGreen(t, y, x);
				break;
			case 3:
				goBlue(t, y, x);
				goGreen(t, y, x);
				break;
			}
		}
		
		for (int i = 0; i < blue.size(); i++) {
			System.out.println(Arrays.toString(blue.get(i)));
		}
		
		for (int i = 0; i < green.size(); i++) {
			System.out.println(Arrays.toString(green.get(i)));
		}
	}
}
