package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SW_D4_01238_Contact {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_1238.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
			for (int i = 0; i < 101; i++) {
				arr.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(!arr.get(a).contains(b)) arr.get(a).add(b);
			}
			
			//연락인원은 최대 100명이라고 해서 101으로 visited의 크기를 정해주었습니다.
			boolean[] visited = new boolean[101];
			Queue<Integer> q = new LinkedList<>();
			q.add(s);			//시작점을 q에 넣어주고 방문처리도 해준 채 bfs를 시작합니다.
			visited[s] = true;
			
			int max = 0;
			
			while(!q.isEmpty()) {
				max = 0;	//가장 먼 곳에서의 max값을 구해야 하므로 가장 먼 곳 즉 마지막으로 while문이 돌 때까지는 계속 0으로 초기화 해줍니다.
				int size = q.size();			//새로 q에 들어온 데이터를 빼지 않기 위해 현재 q의 사이즈를 담아 해당 size만큼만 for문을 실행합니다.
				for (int i = 0; i < size; i++) {
					int now = q.poll();			//일단 현재 거리에서의 최대값을 max로 구해줍니다.
					max = Math.max(now, max);
					
					//현재거리에서 또 갈곳이 있다면 q에 계속 담아주고 bfs를 계속합니다.
					//다만 현재 거리에서 아무것도 q에 담기지 않는다면 현재가 가장 먼 거리 이므로 답이 됩니다.
					//또 자연스레 q에 아무것도 담기지 않았으므로 while문이 종료되며 max의 값을 그대로 사용할 수 있게됩니다.
					ArrayList<Integer> nowArr = arr.get(now);
					for (int j = 0; j < nowArr.size(); j++) {
						int snow = nowArr.get(j);
						if(visited[snow]) continue;
						q.add(snow);
						visited[snow] = true;
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
		
	}

}
