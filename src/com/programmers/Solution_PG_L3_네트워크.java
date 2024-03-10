package com.programmers;

public class Solution_PG_L3_네트워크 {
	static boolean[] net;
	static int idx;

	public static void main(String[] args) throws Exception {
		System.out.println(solution(3, new int[][]{{1, 1, 0},{1, 1, 0},{0, 0, 1}}));
	}

	static int solution(int n, int[][] computers) {
		int answer = 0;
		net = new boolean[n];
		idx = n;

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(computers[i][j] == 1 && !net[j]){
					dfs(j, computers);
					net[j] = true;
					answer++;
				}
			}
			net[i] = true;
		}

		return answer;
	}

	static void dfs(int n, int[][] com){
		for(int i=0; i<idx; i++){
			if(com[n][i] == 1 && !net[i]){
				net[i] = true;
				dfs(i, com);
			}
		}
	}
}
