package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_05397_S2_키로거 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
			while (!q.isEmpty()) {
				char now = q.poll();
				if (now == '<' || now == '>') {
					cs = arrow(now, cs, res.size());
				} else if (now == '-') {
					if (cs > 0) {
						res.remove(cs - 1);
						cs--;
					}
				} else {
					if (cs == res.size()) {
						res.add(now);
						cs++;
					} else {
						res.add(cs, now);
						cs++;
					}
				}
			}
			
			for(Character cur : res) {
				sb.append(cur);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}

	static int arrow(char c, int idx, int size) {
		if (c == '<') {
			if (idx > 0)
				return idx - 1;
			else
				return 0;
		}

		if (c == '>') {
			if (idx < size)
				return idx + 1;
			else
				return size;
		}

		return 0;
	}
}