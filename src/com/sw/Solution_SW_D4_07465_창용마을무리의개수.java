package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SW_D4_07465_창용마을무리의개수 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;

	//한번의 dfs로 갈 수 있는 모든 곳들은 하나의 무리이므로 true 표시를 해줍니다.
	static void dfs(int a) {
		visited[a] = true;

		ArrayList<Integer> nlist = list.get(a);
		for (int i = 0; i < nlist.size(); i++) {
			int now = nlist.get(i);
			if (!visited[now])
				dfs(now);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sw_input_7465.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();

			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				list.get(a).add(b);
				list.get(b).add(a);
			}

			visited = new boolean[N + 1];

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				//하나의 무리를 찾아 cnt++;
				if (!visited[i]) {
					dfs(i);
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
		}

	}

}
