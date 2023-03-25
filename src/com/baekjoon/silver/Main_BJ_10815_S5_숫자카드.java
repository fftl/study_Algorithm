package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BJ_10815_S5_숫자카드 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> have = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			have.add(Integer.parseInt(st.nextToken()));
		}
		
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(have.contains(now)) sb.append(1+" ");
			else sb.append(0+" ");
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
