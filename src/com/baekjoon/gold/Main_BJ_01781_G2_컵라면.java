package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_01781_G2_컵라면 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		boolean[] deadCheck = new boolean[n+1];
		list.add(new int[] {0,0,0});
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int dead = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			
			deadCheck[dead] = true;
			
			list.add(new int[] {dead, cnt, i});
		}
		
//		for (int i = 1; i <= n; i++) {
//			System.out.println(Arrays.toString(list.get(i)));
//		}
//		
		Collections.sort(list, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o2[1]-o1[1];
				} else {
					return o1[0]-o2[0];
				}
			}
		});
		
//		System.out.println("-----------------------------------------");
//		for (int i = 1; i <= n; i++) {
//			System.out.println(Arrays.toString(list.get(i)));
//		}
//		
		int result = 0;
//		for (int i = 1; i <= n; i++) {
//			int[] now = list.get(i);
//			if(deadCheck[now[0]]) { 
//				result+=now[1];
//				deadCheck[now[0]] = false;
//			}
//		}
		
		int idx = 1;
		int cnt = 0;
		while(idx<n) {
			
		}
		
		System.out.println(result);
		
		
	}
}
