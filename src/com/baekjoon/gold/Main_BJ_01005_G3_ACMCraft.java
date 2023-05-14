package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://bcp0109.tistory.com/24
public class Main_BJ_01005_G3_ACMCraft {
	static int[] size, times;
	static int N, K, W;
	static ArrayList<ArrayList<Integer>> arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			size = new int[N+1];
			times = new int[N+1];
			arr = new ArrayList<>();
			for(int i=0; i<N+1; i++) arr.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				times[i+1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				size[b]++;
				arr.get(a).add(b);
			}
			
			int tg = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			int[] result  = new int[N+1];
			
			//선행 조건이 0인 친구들을 먼저 q에 담아주고 시작합니다.
			for (int i = 1; i < N+1; i++) {
				result[i] = times[i];
				if(size[i] == 0) {
					q.add(i);
				}
			}
			
			run : while(!q.isEmpty()) {
				int now = q.poll();
				ArrayList<Integer> nowArr = arr.get(now);
				
				for(int j=0; j<nowArr.size(); j++) {
					result[nowArr.get(j)] = Math.max(result[nowArr.get(j)], result[now]+times[nowArr.get(j)]);
					size[nowArr.get(j)]--;
					if(size[nowArr.get(j)] == 0) {
						q.add(nowArr.get(j));
					}
				}
				
				if(now == tg) break run;
			}
			
			System.out.println(result[tg]);
		}
	}
}
