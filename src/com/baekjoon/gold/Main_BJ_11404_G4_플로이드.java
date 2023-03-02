package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//제목 그대로 플로이드 와샬 알고리즘을 사용해서 풀어야 하는 문제입니다.
public class Main_BJ_11404_G4_플로이드 {
	static int n, m;
	static int[][] dist;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//노드의 크기 n과 버스의 경로 및 비용의 개수인 m을 담아줍니다.
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		//각 경로의 비용의 초기값을 담아줍니다.
		//출발지와 도착지가 같다면 0, 나머지는 모든 경로를 거쳐가더라도 도달할 수 없는 큰 수를 담아줍니다.
		dist = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			for (int j = 1; j<n+1; j++) {
				if(i==j) {
					dist[i][j] = 0;
					 continue;
				} 
				dist[i][j] = 1000000000;
			}
		}
		
		//초기화 된 dist에 이제 실제 값들을 넣어줍니다.
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			dist[a][b] = Math.min(dist[a][b], k);
		}
		
		//모든 경우를 돌며 최소 비용으로 i->j로 갈 수 있는 경우를 찾아냅니다.
		for(int k=1; k<n+1; k++) {
			for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		//StringBuilder를 이용해서 출력합니다.
		//그리고 초기에 넣어주었던 큰 값은 0으로 변환해줍니다.
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(dist[i][j] == 1000000000) dist[i][j] = 0;
				
				if(j<n)sb.append(dist[i][j]+" ");
				else sb.append(dist[i][j]+"\n");
			}
		}
		
		//결과!
		System.out.println(sb.toString().trim());
	}
}
