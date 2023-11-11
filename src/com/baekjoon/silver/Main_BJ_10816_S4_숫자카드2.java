package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_10816_S4_숫자카드2 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(!map.containsKey(now)) {
				map.put(now, 1);
			} else {
				map.put(now, map.get(now)+1);
			}
		}
		
		t = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(map.containsKey(now)) sb.append(map.get(now) + " ");
			else sb.append(0 + " ");
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
