package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D3_05215_햄버거다이어트 {

	static boolean[] visited;
	static int[][] data;
	static int N, L, result;
	
	static void powerSet(int cnt, int score, int cal) {
		if(cnt == N) {
			if(cal<=L) {
				result = Math.max(score, result);
			}
			return;
		}
		
		//파라미터에 점수와 칼로리를 바로바로 계산하며 부분집합을 찾습니다.
		visited[cnt] = false;
		powerSet(cnt+1, score, cal);
		
		visited[cnt] = true;
		powerSet(cnt+1, score+data[cnt][0], cal+data[cnt][1]);
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_5215.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			result = 0;
			visited = new boolean[N];
			
			data = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				data[i][0] = Integer.parseInt(st.nextToken());
				data[i][1] = Integer.parseInt(st.nextToken());
			}
			
			powerSet(0, 0, 0);
			System.out.println("#"+tc+" "+result);
		}
	}
}
