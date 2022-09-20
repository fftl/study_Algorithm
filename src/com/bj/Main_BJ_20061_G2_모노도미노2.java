package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_20061_G2_모노도미노2 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] main = new int[4][4];
		int[][] blue = new int[4][6];
		int[][] green = new int[6][4];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x= Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			switch(t) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}
	}
}
