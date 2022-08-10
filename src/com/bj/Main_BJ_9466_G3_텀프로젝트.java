package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
2
7
3 1 3 7 3 4 6
8
1 2 3 4 5 6 7 8 
*/

public class Main_BJ_9466_G3_텀프로젝트 {
	static boolean[] visited, team, not;
	static int n, end;
	static int[] cnt;
	static ArrayList<Integer> arr;

	static void dfs(int n) {
		//이번 체크, // team Check
		
		if(not[n]) return;
		
		int dfsNow = arr.get(n);

		if (n == dfsNow) {
			team[n] = true;
			end = dfsNow;
			return;
		}

		if (visited[dfsNow]) {
			end = dfsNow;
			return;
		} else {
			visited[dfsNow] = true;
			dfs(dfsNow);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new ArrayList<>();
			team = new boolean[n + 1];
			not = new boolean[n + 1];
			cnt = new int[n + 1];

			arr.add(0);
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int now = Integer.parseInt(st.nextToken());
				cnt[now] += 1;
				arr.add(now);
			}

			System.out.println(arr.toString());

			for (int j = 1; j < arr.size(); j++) {
				if(cnt[j] == 0) {
					not[j] = true;
					continue;
				}
				
				visited = new boolean[n + 1];
				if (team[j] || not[j]) continue;
				int start = j;
				visited[j] = true;
				dfs(j);

				if (start == end) {
					for (int k = 1; k < visited.length; k++) {
						if (visited[k])
							team[k] = true;
					}
				} else {
					not[j] = true;
				}
			}

			int result = 0;
			for (int j = 1; j < team.length; j++) {
				if (!team[j])
					result++;
			}

			System.out.println(result);
		}
	}

}
