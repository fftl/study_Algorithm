package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_14888_S1_연산자끼워넣기 {
	static int N;
	static int max, min;
	static int[] nums;
	static boolean[] visited;
	static boolean first;
	static ArrayList<Integer> cmd;
	
	//dfs를 이용한 풀이를 만들어 보았습니다.
	public static void dfs(int cnt, int now) {
		
		//만약 연산자를 모두 사용했다면 현재 연산의 값으로 max, min값을 갱신해줍니다.
		if(cnt == N) {
			//처음으로 나온 값은 무조건 max, min에 넣어줍니다.
			if(!first) {
				max = now;
				min = now;
				first = true;
			}
			
			max = Math.max(max,  now);
			min = Math.min(min,  now);
			return;
		}
		
		//연산자의 수만큼 돌며 dfs를 실행합니다.
		for (int i = 0; i < cmd.size(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			
			//각각의 숫자에 맞는 연산을 진행시켜 줍니다.
			if(cmd.get(i) == 0) {
				dfs(cnt+1, now+nums[cnt]);
			} else if(cmd.get(i) == 1) {
				dfs(cnt+1, now-nums[cnt]);
			} else if(cmd.get(i) == 2) {
				dfs(cnt+1, now*nums[cnt]);
			} else {
				dfs(cnt+1, now/nums[cnt]);
			}
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		cmd = new ArrayList<>();
		first = false;	//처음 발견하는 값을 max, min 모두에 넣어주어 시작 숫자를 만들어주기 위함 입니다.
		
		//데이터 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N-1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k ; j++) {
				cmd.add(i);
			}
		}
		
		//첫번째 숫자는 항상 같으므로 넣어주고 시작을합니다.
		dfs(1, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
	}
}
