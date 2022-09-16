package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_17822_G3_원판돌리기 {
	static int N, M, T, zero;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static ArrayList<ArrayList<Integer>> arr;
	
	//원판을 돌려줍니다.
	static void move(int n, int key, int t) {
		if(key == 0) { //시계방향 으로 돌려줍니다.
			for(int i=n; i<=N; i+=n) {
				ArrayList<Integer> now = arr.get(i);
				for(int j=0; j<t; j++) {
					int end = now.get(now.size()-1);
					now.remove(now.size()-1);
					now.add(0, end);
				}
			}
		} else {
			for(int i=n; i<=N; i+=n) {
				ArrayList<Integer> now = arr.get(i);
				for(int j=0; j<t; j++) {
					int first = now.get(0);
					now.remove(0);
					now.add(now.size(), first);
				}
			}
		}
	}
	
	//인접한 곳에 같은 수가 있는 경우를 확인하여 존재 할 경우 
	static void check() {
		boolean[][] visited = new boolean[N+1][M];
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> change = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				if(arr.get(i).get(j) == 0) continue;
				visited[i][j] = true;
				q = new LinkedList<>();
				change = new LinkedList<>();
				
				q.add(new int[] {i,j});
				change.add(new int[] {i,j});
				
				while(!q.isEmpty()) {
					int size = q.size();
					for (int s = 0; s < size; s++) {
						int[] now = q.poll();
						int nowNum = arr.get(now[0]).get(now[1]);
						
						for(int k=0; k<4; k++) {
							int ny = now[0] + dy[k];
							int nx = now[1] + dx[k];
							
							if(nx == -1) nx = M-1;
							if(nx == M) nx = 0;
							
							if(1<=ny && ny<=N && 0<=nx && nx<M && !visited[ny][nx]) {
								int another = arr.get(ny).get(nx);
								if(nowNum == another) {
									visited[ny][nx] = true;
									q.add(new int[] {ny, nx});
									change.add(new int[] {ny, nx});
								}
							}
						}
						
					}
				}
				if(change.size()>1) {
					zero += change.size();
					while(!change.isEmpty()) {
						int[] point = change.poll();
						arr.get(point[0]).set(point[1], 0);
					}
				}
			}
		}
		

	}
	//인접한 곳에 같은 수가 하나도 없을 경우 입니다.
	static void nothing(int sum) {
		double nsum = sum;
		double cnt = (N*M)-zero;
		double avg = nsum/cnt;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				int now = arr.get(i).get(j);
				if(now == 0) continue;
				
				if(now>avg) {
					arr.get(i).set(j, now-1);
				} else if (now<avg){
					arr.get(i).set(j, now+1);
				}
			}
		}
		
	}
	
	//모든 원판의 수의 합을 구합니다.
	static int sum() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				sum += arr.get(i).get(j);
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		zero = 0;
		
		arr = new ArrayList<>();
		arr.add(new ArrayList<>()); //0인덱스를 미리 채워줍니다.
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> now = new ArrayList<>();
			for (int j = 0; j < M; j++) {
				now.add(Integer.parseInt(st.nextToken()));
			}
			arr.add(now);
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			move(n, key, t);
			int before = sum();
			check();
			int after = sum();
			
			if(before == after) {
				nothing(after);
			}
		}
		
		System.out.println(sum());
	}
}
