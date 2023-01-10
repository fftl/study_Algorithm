package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_11403_S1_경로찾기 {
	static int N;
	static int [][] arr, board;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		board = new int[N][N]; 

		//양방향의 경로를 ArrayList에 담아줍니다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				arr[i][j] = n;
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(j!=N-1) sb.append(arr[i][j]+" ");
				else sb.append(arr[i][j]+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}

