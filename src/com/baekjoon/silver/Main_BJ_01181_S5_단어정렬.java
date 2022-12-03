package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_BJ_01181_S5_단어정렬 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			String now = br.readLine();
			if(!list.contains(now)) list.add(now);
		}

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if(a.length()!=b.length()) {
					return a.length()-b.length();
				} else {
					for (int i = 0; i < a.length(); i++) {
						if(a.charAt(i) != b.charAt(i)) {
							return a.charAt(i)-b.charAt(i);
						}
					}
				}
				return 0;
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
