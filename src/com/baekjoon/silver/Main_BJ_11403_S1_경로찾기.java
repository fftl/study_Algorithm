package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_11403_S1_경로찾기 {
	static int N;
	static int [][] board;
	static ArrayList<ArrayList<Integer>> arr;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		for (int i = 0; i < N; i++) arr.add(new ArrayList<>()); 

		//양방향의 경로를 ArrayList에 담아줍니다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1) {
					arr.get(i).add(j);
					arr.get(j).add(i);
				}
			}
		}

		System.out.println(arr.toString());
		board = new int[N][N];

		//i에서 갈 수 있는 now들을 담아줍니다.
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j=0; j<arr.get(i).size(); j++){
				int now = arr.get(i).get(j);

				//만약에 i에서 j를 가본적이 없다면
				if(board[i][now] == 0){
					board[i][now] = 1;
					q.add(now);
				}

				//처음 가보는 곳이 존재한다면,
				while(!q.isEmpty()){
					int num = q.poll();
					for(int k=0; k<arr.get(num).size(); k++){
						int now2 = arr.get(num).get(k);
						if(board[i][now2] == 0) board[i][now2] = 1;
						if(board[num][now2] == 0){
							q.add(now2);
						}
					}
				}
			}
		}
		System.out.println(Arrays.deepToString(board));
	}
}
