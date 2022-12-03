package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_15686_G5_치킨배달 {

	static ArrayList<int[]> homes, chickens;
	static int[] result;
	static boolean[] visited;
	static int answer;

	static void comb(int cnt, int s, int end) {
		// end는 이번에 뽑을 치킨집 개수
		if(cnt == end) { 
			int n=0;
			//각각의 집의 치킨거리를 구해줍니다.
			for (int i = 0; i < homes.size(); i++) {
				int[] home = homes.get(i);
				int minC = Integer.MAX_VALUE;
				
				for(int j=0; j<result.length; j++) {
					int[] chicken = chickens.get(result[j]);
					int now = Math.abs(home[0]-chicken[0]) + Math.abs(home[1]-chicken[1]);
					minC = Math.min(minC, now);
				}
				
				//치킨거리를 n에 더해줍니다.
				n += minC;
			}
			
			//n으로 최소값인지 확인하여 갱신해줍니다.
			answer = Math.min(n, answer);
			return;
		}
		
		for(int i=s; i<chickens.size(); i++) {
			result[cnt] = i;
			comb(cnt+1, i+1, end);
		}
		
	}

	public static void main(String[] args) throws Exception {

		//집의 목록!
		homes = new ArrayList<>();
		//치킨집 목록!
		chickens = new ArrayList<>();
		//답을 담을 answer!
		answer = Integer.MAX_VALUE;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N+1][N+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//데이터입력
		
		//arr를 돌며 집과 치킨집을 각각 찾아서 homes, chickes에 담아줍니다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1)
					homes.add(new int[] { i, j });
				if (arr[i][j] == 2)
					chickens.add(new int[] { i, j });
			}
		}

		//그리고 폐업시키지 않을 치킨집을 최대 M개 고를 수 있으므로
		//모든 치킨집중에서 1 ~ M개 까지의 수를 가지는 치킨집 조합을 찾아냅니다.
		for (int i = 1; i <= M; i++) {
			visited = new boolean[chickens.size()];
			result = new int[i];
			comb(0, 0, i); //i개의 치킨집을 뽑는 조합!
		}
		
		System.out.println(answer);
	}
}
