package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SW_D4_05643_키순서 {
	static int N, M;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_5643.txt")); // input 가져오기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			boolean[][] check = new boolean[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				check[a][b] = true;
			}
			
			for (int k = 1; k < N+1; k++) {
				for (int i = 1; i < N+1; i++) {
					for (int j = 1; j < N+1; j++) {
						if(check[i][k] && check[k][j]) {
							check[i][j] = true;
						}
					}
				}
			}
			
			int[] cnt = new int[N+1];
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if(check[i][j] || check[j][i]) {
						cnt[i]++;
					}
				}
			}
			
			int result = 0;
			for (int i = 0; i < cnt.length; i++) {
				if(cnt[i] == N-1) result++; 
			}
			
			System.out.println("#"+tc+" "+result);
		}
		
	}

}