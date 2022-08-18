package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
5 5
0 1
1 2
2 3
3 0
1 4
*/
public class Main_BJ_13023_G5_ABCDE {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> arr;
	static int result;
	
	static void dfs(int n, boolean[] visited, int cnt) {
		if(result != 0) return;
		if(cnt>=4) {
			result = 1;
			return;
		}
		
		//현재 n에서 갈 수 있는 방향들!
		ArrayList<Integer> nowArr = arr.get(n);
		
		for (int i = 0; i < nowArr.size(); i++) {
			if(visited[nowArr.get(i)]) continue;
			visited[nowArr.get(i)] = true;
			dfs(nowArr.get(i), visited, cnt+1);
			//나올때 false 체크! 다음에 확인할 때 다시 봐야하니까
			visited[nowArr.get(i)] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		result = 0;

		arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr.add(new ArrayList<>());
		}

		//양방향 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		System.out.println(arr.toString());
		for (int i = 0; i < arr.size(); i++) {
			visited = new boolean[N];
			visited[i] = true;
			dfs(i, visited, 0);
		}
		
		System.out.println(result);
	}
}
