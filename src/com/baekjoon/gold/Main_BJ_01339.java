package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main_BJ_01339_G4_단어수학 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//이미 숫자가 정의된 알파벳을 체크하기 위한 String 입니다.
		HashMap<Character, Integer> map = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.length() - a.length();
			}
		});
		
		String[] strs = new String[N];
		for (int i = 0; i < N; i++) {
			String now = br.readLine();
			pq.add(now);
			strs[i] = now;
		}
		
		int num = 9;
		while(!pq.isEmpty()) {
			String now = pq.poll();
			char first = now.charAt(0);
			if(map.containsKey(first)) {
				String next = now.substring(1, now.length());
				if(next.length()>0) pq.add(next);
			} else {
				map.put(first, num);
				num--;
				String next = now.substring(1, now.length());
				if(next.length()>0) pq.add(next);
			}
		}
		
		int result = 0;
		for (int i = 0; i < strs.length; i++) {
			String nowNum = "";
			String now = strs[i];
			for (int j = 0; j < now.length(); j++) {
				nowNum += map.get(now.charAt(j));
			}
			result += Integer.parseInt(nowNum);
		}
		
		System.out.println(result);
	}
}
