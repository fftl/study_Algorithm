package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_01292_B1_쉽게푸는문제 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < 200; i++) {
			for (int j = 0; j < i; j++) {
				list.add(i);
				if(list.size()>1000) break;
			}
			if(list.size()>1000) break;
		}
		
		int res = 0;
		for (int i = a-1; i < b; i++) {
			res+=list.get(i);
		}
		
		System.out.println(res);
	}
}
