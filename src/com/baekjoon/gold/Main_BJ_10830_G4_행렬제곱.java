package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10830_G4_행렬제곱 {
	
	static int[][] board;
	static int n;
	
	//행렬의 곱을 분할합니다.
	static int[][] div(long b){
		if(b==1) return board;
		
		int[][] memo = div(b/2);
		
		if(b%2==0) {
			return gop(memo, memo);
		} else {
			return gop(gop(memo, memo), board);
		}
	}
	
	//행렬의 곱셈!
	static int[][] gop(int[][] a, int[][] b){
		int[][] result = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = 0; k < n; k++) {
					sum += a[i][k] * b[k][j];
				}
				result[i][j] = sum%1000;
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		board = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		
		int[][] result = div(b);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(j<n-1) {
					sb.append(result[i][j]+" ");
				} else {
					sb.append(result[i][j]+"\n");
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
