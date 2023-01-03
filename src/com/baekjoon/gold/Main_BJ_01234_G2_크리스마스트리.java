package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01234_G2_크리스마스트리 {
	static int N, R, G, B;
	static int[] fact;
	static long[][][][] res;
	
	static int getFacto(int n) {
		if(n==0 || n==1) return 1;
		if(fact[n]>0) return fact[n];
		return fact[n] = n* getFacto(n-1);
	}
	
	static int numCase(int facto, int r, int g, int b) {
		return facto / getFacto(r) / getFacto(g) / getFacto(b);
	}
	
	static long dfs(int lv, int r, int g, int b) {
		if(lv>N) return 1;
		if(res[lv][r][g][b] != 0) return res[lv][r][g][b];
		long now = 0;
		
		if(R-r >= lv) now += dfs(lv+1, r+lv, g, b);
		if(G-g >= lv) now += dfs(lv+1, r, g+lv, b);
		if(B-b >= lv) now += dfs(lv+1, r, g, b+lv);
		
		if(lv%2==0) {
	        if(R - r >= lv/2 && G - g >= lv/2){
	        	now += (numCase(getFacto(lv), lv/2, lv/2, 0) * dfs(lv+1, r+lv/2, g+lv/2, b));
	        }
	        if(B - b >= lv/2 && G - g >= lv/2) {
	        	now += (numCase(getFacto(lv), 0, lv/2, lv/2) * dfs(lv+1, r, g+lv/2, b+lv/2));
	        }
	        if(R - r >= lv/2 && B - b >= lv/2){
	        	now += (numCase(getFacto(lv), lv/2, 0, lv/2) * dfs(lv+1, r+lv/2, g, b+lv/2));
	        }
		}
		
		if(lv % 3 == 0 && R - r >= lv/3 && G - g >= lv/3 && B - b >= lv/3){
	        now += (numCase(getFacto(lv), lv/3, lv/3, lv/3) * dfs(lv+1, r+lv/3, g+lv/3, b+lv/3));
	    }
		
		return now;
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		fact = new int[11];
		res = new long[11][60][60][60];
		
		long result = dfs(1, 0, 0, 0);
		
		System.out.println(result);
	}
}
