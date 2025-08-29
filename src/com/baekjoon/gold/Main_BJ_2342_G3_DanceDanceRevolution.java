package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2342_G3_DanceDanceRevolution {

	static int[][][] dp;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();

		while(true){
			int n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			list.add(n);
		}
//		System.out.println(list);

		dp = new int[5][5][list.size()];
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(solve(0,0,0));

	}

	static int solve(int left, int right, int cnt){
		if(cnt == list.size()) return 0;
		if(dp[left][right][cnt] != -1 ) return dp[left][right][cnt];

		dp[left][right][cnt] = Math.min(solve(list.get(cnt),right,cnt+1)+energy(left, list.get(cnt)), solve(left, list.get(cnt), cnt+1)+energy(right, list.get(cnt)));
		return dp[left][right][cnt];
	}

	static int energy(int pos, int des){
		int num = Math.abs(pos-des);
		if(pos == 0) return 2;
		else if(num == 0) return 1;
		else if(num == 1 || num == 3) return 3;
		else return 4;
	}
}
