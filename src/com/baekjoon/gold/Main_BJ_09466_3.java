package com.baekjoon.gold;

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

public class Main_BJ_09466_G3_텀프로젝트_b {
	static boolean[] visited, team, not;
	static int n, end;
	static int[] cnt;
	static ArrayList<Integer> arr;

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
			
			//출발 도착이 같은애들을 찾아서 담아줍니다. ex) 3 - 3
			ArrayList<Integer> same = new ArrayList<>();
			for (int j = 1; j < arr.size(); j++) {
				if(arr.get(j) == j) {
					team[j] = true;
					same.add(j);
				}
			}
			
			//same에 포함된 곳으로 가는 애들은 not
			//본인으로 도착하는 출발지가 하나도 없다면 not
			for (int j = 1; j < arr.size(); j++) {
				if(team[j]) continue;
				if(same.contains(arr.get(j))) {
					not[j] = true;
					continue;
				}
				
				if(cnt[j] == 0) {
					not[j] = true;
				}
			}

			int result = 0;
			for (int j = 1; j < n+1; j++) {
				if (not[j])
					result++;
			}

			System.out.println(result);
		}
	}

}
