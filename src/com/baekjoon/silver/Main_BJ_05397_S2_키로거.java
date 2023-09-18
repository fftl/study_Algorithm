package com.baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class Main_BJ_05397_S2_키로거 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			Queue<Character> q = new LinkedList<Character>();
			for (int j = 0; j < str.length(); j++) {
				q.add(str.charAt(j));
			}

			int cs = 0;
			LinkedList<Character> res = new LinkedList<>();
			ListIterator<Character> it = res.listIterator();
			while (!q.isEmpty()) {
				char now = q.poll();
				if(now=='<') {
					if(it.hasPrevious()) {
						it.previous();
					}
				} else if(now=='>') {
					if(it.hasNext()) {
						it.next();
					}
				} else if(now=='-') {
					if(it.hasPrevious()) {
						it.previous();
						it.remove();
					}
				} else {
					it.add(now);
				}
			}

			for(Character cur : res) {
				sb.append(cur);
			}
			sb.append("\n");
		}
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
		br.close();
	}

}
