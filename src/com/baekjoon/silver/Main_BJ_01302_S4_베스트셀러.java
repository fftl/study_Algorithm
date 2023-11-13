package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_01302_S4_베스트셀러 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashMap<String, Integer> cnt = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String now = br.readLine();
			if(!cnt.containsKey(now)){
				cnt.put(now, 1);
			} else {
				cnt.put(now, cnt.get(now)+1);
			}
		}

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(cnt.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if(o2.getValue()==o1.getValue()){
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue()-o1.getValue();
			}
		});

		System.out.println(entryList.get(0).getKey());
	}
}
