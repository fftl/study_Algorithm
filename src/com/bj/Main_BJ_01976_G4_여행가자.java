package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_01976_G4_여행가자 {

	static int N, M;
	static ArrayList<ArrayList<Integer>> arr;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		
		for (int i = 0; i < N+1; i++) { //도시번호는 1부터이므로 +1만큼 리스트를 만들어줍니다. 
			arr.add(new ArrayList<>());
		}
		
		//어차피 데이터 자체를 양방향으로 주어지기 때문에 이렇게 arr에 담아줍니다.
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j<= N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					arr.get(i).add(j);
				}
			}
		}
		System.out.println(arr.toString());
		
		st = new StringTokenizer(br.readLine());
		
		//방문 해야하는 경로를 root 큐에다가 담아주었습니다.
		Queue<Integer> root = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			root.add(Integer.parseInt(st.nextToken()));
		}
		
		//bfs를 돌 q 큐 입니다.
		//출발지를 담아주고 시작합니다.
		Queue<Integer> q = new LinkedList<>();
		q.add(root.poll());
		
		//방문처리를 해줄 visited 입니다.
		boolean[] visited = new boolean[N+1];
		
		while(!q.isEmpty()) {
			if(root.isEmpty()) break;//모든 root에 방문했으므로 종료합니다.
			int size = q.size();//새로들어온 데이터는 돌지않기 위해 size를 담아주고 for를 실행해줍니다.
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				
				/*
				 만약 이번에 도착한 곳이 이번에 가야할 목적지였다면 root에서 빼서 왔음을 확인해주고 (root.poll())
				 갔던 곳에 다시 갈 수 있어야 하니까 visited를 초기화해줍니다.
				 또 지금까지 쌓여있던 q도 초기화 해주어서 이번 위치부터 bfs를 다시 시작해줍니다.
				 */
				if(root.peek() == now) {
					int r = root.poll();
					visited = new boolean[N+1];
					visited[r] = true;
					q.clear();
					q.add(r);
					break;
				}
				
				//목적지가 나올때 까지 이번 위치에서 갈 수 있는 곳들을 q에 담아서 방문처리 해줍니다.
				ArrayList<Integer> nowArr = arr.get(now);
				for (int j = 0; j < nowArr.size(); j++) {
					if(!visited[nowArr.get(j)]) {
						visited[nowArr.get(j)] = true;
						q.add(nowArr.get(j));
					}
				}
			}
			
		}
		
		//root를 순서대로 들를 수 있었다면 root가 비어 있어야 하므로 yes 아니라면 no
		if(root.isEmpty()) System.out.println("YES");
		else System.out.println("NO");
		
	}
}
