package com.zother.mock;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D0_04013_특이한자석 {

	static boolean[][] magnet;
	
	//해당 자석을 오른쪽, 왼쪽으로 돌려주는 작업입니다.
	static void move(int n, int key) {
		if(key != 1) {
			boolean temp = magnet[n][0];
			for (int i = 0; i < 7; i++) {
				magnet[n][i] = magnet[n][i+1];
			}
			magnet[n][7] = temp;
		} else {
			boolean temp = magnet[n][0];
			for (int i = 7; i>1; i--) {
				if(i==7) magnet[n][0] = magnet[n][i];
				magnet[n][i] = magnet[n][i-1];
			}
			magnet[n][1] = temp;
		}
	}
	
	//방향을 확인하는?
	static void turn(int n, int key) {
		int origin = n;
		boolean[] visited = new boolean[3]; //
		
		for (int i = 0; i < 3; i++) {
			if(magnet[i][2] != magnet[i+1][6]) {
				visited[i] = true;
			}
		}
		
		move(n, key);
		while(0<n) {
			if(!visited[n-1]) break;
			n = n-1;
			if(Math.abs(origin-n)%2==0) {
				move(n, key);
			} else {
				move(n, key*-1);
			}
		}
		
		n = origin;
		while(n<3) {
			if(!visited[n]) break;
			n = n+1;
			if(Math.abs(origin-n)%2==0) {
				move(n, key);
			} else {
				move(n, key*-1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_4013.txt")); // input 가져오기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			magnet = new boolean[4][8];
			for (int i = 0; i < magnet.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = st.nextToken().equals("0") ? false : true;
				}
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int key = Integer.parseInt(st.nextToken());
				
				turn(n-1, key);
				
			}
			
			int result = 0;
			
			for (int i = 0; i < magnet.length; i++) {
				if(magnet[i][0]) result += Math.pow(2, i);
			}
			
			System.out.println("#"+tc+" "+result);
		}
	}

}
