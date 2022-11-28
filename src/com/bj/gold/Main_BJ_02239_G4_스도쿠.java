package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_02239_G4_스도쿠 {
	static class Node{
		int y, x;
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + "]";
		}
	}
	
	static int N, sum;
	static int[][] map;
	static ArrayList<Node> list;
	
	static boolean[] area(int y, int x, boolean[] nums) {
		if(y<3) {
			if(x<3) { //1==================================================
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			} else if(x<6){
				for (int i = 0; i < 3; i++) {
					for (int j = 3; j < 6; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			} else {
				for (int i = 0; i < 3; i++) {
					for (int j = 6; j < 9; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			}
		} else if(y<6) { //2==================================================
			if(x<3) {
				for (int i = 3; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			} else if(x<6){
				for (int i = 3; i < 6; i++) {
					for (int j = 3; j < 6; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			} else {
				for (int i = 3; i < 6; i++) {
					for (int j = 6; j < 9; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			}
			
		} else { //3==================================================
			if(x<3) {
				for (int i = 6; i < 9; i++) {
					for (int j = 0; j < 3; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			} else if(x<6){
				for (int i = 6; i < 9; i++) {
					for (int j = 3; j < 6; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			} else {
				for (int i = 6; i < 9; i++) {
					for (int j = 6; j < 9; j++) {
						if(!nums[map[i][j]]) nums[map[i][j]] = true;
					}
				}
			}
		}
		
		return nums;
	}
	
	static int find(int k) {
		if(list.size() == k) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(Integer.toString(map[i][j]));
				}
				System.out.println();
			}
			
			System.exit(0);
		}
		
		Node now = list.get(k);
		int y = now.y;
		int x = now.x;
		
		boolean[] nums = new boolean[10];
		nums = area(y, x, nums);
		
		for (int i = 0; i < 9; i++) {
			if(!nums[map[y][i]]) nums[map[y][i]] = true;
			if(!nums[map[i][x]]) nums[map[i][x]] = true;
		}
		
		for (int i = 1; i <= 9; i++) {
			if(!nums[i]) {
				map[y][x] = i;
				find(k+1);
				map[y][x] = 0;
			}
		}
		
		
		return 0;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		list = new ArrayList<>();
		sum = 0;
		for (int i = 0; i < 9; i++) {
			char[] now = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = now[j]-'0'; 
				sum += map[i][j];
				if(map[i][j] == 0) {
					list.add(new Node(i, j));
				}
			}
		}
		
		find(0);
		
	}
}
