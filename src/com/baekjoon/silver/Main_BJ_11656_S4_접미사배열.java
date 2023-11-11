package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_11656_S4_접미사배열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < st.length(); i++) {
			list.add(new String(st.substring(i, st.length())));
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		for (String s : list){
			sb.append(s+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
