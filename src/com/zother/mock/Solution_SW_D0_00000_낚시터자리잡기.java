package com.zother.mock;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D0_00000_낚시터자리잡기 {
	
	//static class
	static class Fis{
		int idx;
		int size;
		
		public Fis(int idx, int size) {
			this.idx = idx;
			this.size = size;
		}
	}
	
	//static fields
	static Fis[] farr = new Fis[3];
	
	//main
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_mock08_01.txt")); // input 가져오기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				farr[i] = new Fis(idx, size);
			}
			
			int[][] cases = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,0,1}};
			
			for(int[] c : cases) {
				char[] visited = new char[n];
				Arrays.fill(visited, '0');
				
				for(int now:c) {
					while(farr[now].size>0) {
						if(farr[now].size == 0) {
							
						}
					}
				}
			}
		}
	}

}
