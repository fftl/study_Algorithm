package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_25711_G5_인경산 {
	static int N, Q;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		list = new ArrayList<int[]>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new int[2]);
		}
		
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				list.get(j)[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		double[] len = new double[N];
		double[] upSum = new double[N+1];
		double[] downSum = new double[N+1];
		
		for (int i = 1; i < N; i++) {
			int[] before = list.get(i);
			int[] after = list.get(i+1);
			
			len[i] = Math.pow(Math.pow(before[0]-after[0], 2)+Math.pow(before[1]-after[1], 2), 0.5);
		}
		
		for (int i = 1; i < N; i++) {
			int[] before = list.get(i);
			int[] after = list.get(i+1);
			
			if(before[1]<after[1]) {
				upSum[i+1] = upSum[i]+(len[i]*3);
			} else if(before[1]>after[1]){
				upSum[i+1] = upSum[i]+len[i];
			} else {
				upSum[i+1] = upSum[i]+(len[i]*2);
			}
		}
		
		for (int i = N-1; i >= 1; i--) {
			int[] before = list.get(i+1);
			int[] after = list.get(i);
			
			if(before[1]<after[1]) {
				downSum[i-1] = downSum[i]+(len[i]*3);
			} else if(before[1]>after[1]){
				downSum[i-1] = downSum[i]+len[i];
			} else {
				downSum[i-1] = downSum[i]+(len[i]*2);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a<b) {
				sb.append((upSum[b]-upSum[a])+"\n");
			} else {
				sb.append((downSum[b-1]-downSum[a-1])+"\n");
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
