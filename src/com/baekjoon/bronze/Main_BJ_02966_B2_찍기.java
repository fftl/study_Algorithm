package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main_BJ_02966_B2_찍기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "Adrian");
		map.put(1, "Bruno");
		map.put(2, "Goran");

		String[] rule = new String[3];
		rule[0] = "ABC";
		rule[1] = "BABC";
		rule[2] = "CCAABB";

		ArrayList<Integer> winner = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < 3; i++) {
			String now = rule[i];
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == now.charAt(j%now.length())) cnt++;
			}

			if(max<cnt){
				max = cnt;

				winner.clear();
				winner.add(i);

			} else if(max == cnt){
				winner.add(i);
			}
		}

		System.out.println(max);
		for(int idx : winner) System.out.println(map.get(idx));
	}
}
