package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_D3_04012_요리사 {

	static int N, Ascore, Bscore;
	static int[] Aresult, Bresult, permu;
	static int[][] board;
	static boolean[] visited;
	static int min;
	
	static void comb2(int cnt, int s, int[] result, boolean key) {
		if(cnt == 2) {
			if(key) Ascore += board[permu[0]][permu[1]] + board[permu[1]][permu[0]];
			else Bscore += board[permu[0]][permu[1]] + board[permu[1]][permu[0]];
			return;
		}
		
		for(int i=s; i<result.length; i++) {
			permu[cnt] = result[i];
			comb2(cnt+1, i, result, key);
		}
	}
	
	static void comb(int cnt, int s) {
		if(cnt == N/2) {
			visited = new boolean[N/2];
			permu = new int[2];
			Ascore = 0;
			Bscore = 0;
			int idx=0;
			for(int i=0; i<N; i++) {
				boolean check = false;
				
				for(int j=0; j<Aresult.length; j++) {
					if(i == Aresult[j]) check = true;
				}
				if(!check) {
					Bresult[idx] = i;
					idx++;
				}
			}
			comb2(0, 0, Aresult, true);
			comb2(0, 0, Bresult, false);
			min = Math.min(min, Math.abs(Ascore-Bscore));
			
			return;
		}
		
		for(int i=s; i<N; i++) {
			Aresult[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_4012.txt")); // input 가져오기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			Aresult = new int[N/2];
			Bresult = new int[N/2];
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < board.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0);
			
			System.out.println("#"+tc+" "+min);
		}
	}

}
