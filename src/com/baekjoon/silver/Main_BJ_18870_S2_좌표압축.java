package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_18870_S2_좌표압축 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(!map.containsKey(now)) {
				map.put(now, 0);
				list.add(now);
			}
			arr[i] = now;
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			int now = list.get(i);
			map.put(now, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(map.get(arr[i])+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
