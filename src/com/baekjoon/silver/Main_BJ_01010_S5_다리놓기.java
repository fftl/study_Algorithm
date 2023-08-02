package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01010_S5_다리놓기 {
	static int cnt, n, m;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			cnt = 0;
			
			dfs(0, 0, 1);
			
			System.out.println(cnt);
		}
	}
	
	static void dfs(int a, int b, int depth) {
		if(depth == n) {
			cnt++;
		}
		
		for (int i = a; i < n; i++) {
			for (int j = b; j < m; j++) {
				dfs(i, j, depth + 1);
			}
		}
		
	}
}
