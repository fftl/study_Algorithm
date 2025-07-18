package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_11728_S5_배열합치기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for(int i : list){
			sb.append(i+" ");
		}

		System.out.println(sb.toString().trim());
	}
}
