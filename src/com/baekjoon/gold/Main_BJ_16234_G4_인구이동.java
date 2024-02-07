package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_16234_G4_인구이동 {
	static int N,L,R, result;
	static int[][] board, index;
	static int[] able;
	static ArrayList<ArrayList<Integer>> group;
	static ArrayList<int[]> point;
	static boolean stop;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		index = new int[N][N];
		able = new int[N*N];
		group = new ArrayList<>();
		point = new ArrayList<>();
		result = 0;
		stop = false;
		setGroup();

		setAble();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				index[i][j] = idx++;
				point.add(new int[]{i, j});
			}
		}

		while(!stop){
			run();
			System.out.println("test");
		}

		System.out.println(result);
	}
	
	static void setGroup(){
		for (int i = 0; i < N*N; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(i);

			group.add(list);
		}
	}

	static void setAble(){
		for (int i = 0; i < N*N; i++) {
			able[i] = i;
 		}
	}

	static void run(){
		boolean run = false;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int now = board[i][j];
				if(i+1<N){
					//차가 L과 R 사이의 범위에 포함된다면
					int cha = Math.abs(board[i][j]-board[i+1][j]);
					if(L<=cha && cha<=R){
						int nowIdx = index[i][j];
						int nxtIdx = index[i+1][j];

						int parent = able[nowIdx];
						group.get(parent).add(index[i+1][j]);
						able[nxtIdx] = parent;

						run = true;
					}
				}

				if(j+1<N){
					//차가 L과 R 사이의 범위에 포함된다면
					int cha = Math.abs(board[i][j]-board[i][j+1]);
					if(L<=cha && cha<=R){
						int nowIdx = index[i][j];
						int nxtIdx = index[i][j+1];

						int parent = able[nowIdx];
						group.get(parent).add(index[i][j+1]);
						able[nxtIdx] = parent;

						run = true;
					}
				}
			}
		}

		if(!run){
			stop = true;
			return;
		}

		result++;

		for (int i = 0; i < N*N; i++) {
			if(group.get(i).size() != 1){
				int sum = 0;
				int cnt = 0;
				for (int j = 0; j < group.get(i).size(); j++) {
					int[] nowPoint = point.get(group.get(i).get(j));
					sum += board[nowPoint[0]][nowPoint[1]];
					cnt++;
				}

				int val = sum/cnt;
				for (int j = 0; j < group.get(i).size(); j++) {
					int[] nowPoint = point.get(group.get(i).get(j));
					board[nowPoint[0]][nowPoint[1]] = val;
				}
			}
		}

		System.out.println(group.toString());
		setAble();
		setGroup();
	}
}
