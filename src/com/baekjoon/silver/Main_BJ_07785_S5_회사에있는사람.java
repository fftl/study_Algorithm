package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_BJ_07785_S5_회사에있는사람 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		TreeSet<String> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			
			if(set.contains(name)) set.remove(name);
			else set.add(name);
		}
		
		while(!set.isEmpty()) {
			System.out.println(set.pollLast());
		}
	}
}
