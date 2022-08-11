package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11724_S2_연결요소의개수 {

	public static void main(String[] args) throws Exception {

		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N + 1];

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int key = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			// 만약 해당 key를 가진 데이터가 없다면 ArrayList를 넣어 초기화!
			// 이미 key를 가진 데이터가 존재한다면 skip!
			map.putIfAbsent(key, new ArrayList<>());
			map.putIfAbsent(val, new ArrayList<>());

			map.get(key).add(val);
			map.get(val).add(key);
		}

		System.out.println(map.toString());
		
		int result = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i : map.keySet()) {  // map에 존재하는 key들을 하나씩 반환
			if (visited[i]) continue; // 이미 방문한 곳이면 검사 불필요 skip
			
			q.add(i); 			//방문한적이 없다면 q에 넣고 bfs 시작
			visited[i] = true;	//방문표시
			while (!q.isEmpty()) {
				int temp = q.poll(); 		  // 맨앞에 데이터를 꺼내서
				for (int n : map.get(temp)) { // 해당 노드에서 갈 수 있는 곳들을
					if (!visited[n]) {
						q.add(n);   		  // 방문하지 않았따면 추가!
						visited[n] = true; 	  // q에 넣어주며 바로 방문표시를 하여 한번 갔던곳을 또 가지 않도록 합니다.
					}
				}
			}
			result++;
		}

		// 간선을 가지고 있지 않아 최초의 map 에 포함되지 않은 정점들도 각각이 하나의 요소이므로
		// 개수를 세어줍니다.
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i] && map.get(i) == null)
				result++;
		}

		System.out.println(result);

	}// main
}// mainClass
