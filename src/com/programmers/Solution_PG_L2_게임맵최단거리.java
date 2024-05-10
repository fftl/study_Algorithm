package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_PG_L2_게임맵최단거리 {

	public static void main(String[] args) throws Exception {
		System.out.println(solution(new int[][]{
				{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
		}));
	}

	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};

	static public int solution(int[][] maps) {
		int answer = -1;
		int my = maps.length;
		int mx = maps[0].length;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0,0});
		boolean[][] visited = new boolean[maps.length][maps[0].length];

		int len = 1;

		run : while(!q.isEmpty()){
			len++;
			int size = q.size();
			for(int i=0; i<size; i++){
				int[] now = q.poll();
				for(int j=0; j<4; j++){
					int ny = now[0]+dy[j];
					int nx = now[1]+dx[j];
					if(0<=ny && ny<my && 0<=nx && nx<mx && maps[ny][nx] == 1 && !visited[ny][nx]){
						if(ny==my-1 && nx==mx-1){
							answer = len;
							break run;
						}  else {
							q.add(new int[]{ny, nx});
							visited[ny][nx] = true;
						}
					}
				}
			}
		}

		return answer;
	}
}
