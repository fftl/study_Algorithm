package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_11403_S1_경로찾기 {
	static int N;
	static int [][] board;
	static ArrayList<ArrayList<Integer>> arr;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		
		arr = new ArrayList<>();
		for (int i = 0; i < N; i++) arr.add(new ArrayList<>()); 
		
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
		
		int[][] board = new int[t][t];
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < board.length; i++) {
			
		}
		
	}
}
