package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_09375_S3_패션왕신해빈 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String category = st.nextToken();
				
				if(map.containsKey(category)) {
					map.put(category, map.get(category)+1);
				} else {
					map.put(category, 1);
				}
			}
			int result = 0;
			if(map.size() == 0) {
				sb.append(0+"\n");
				continue;
			} else {
				int now = 1;
				for (String next : map.keySet()) {
					now *= map.get(next)+1;
				}
				result += now;
			}
			
			sb.append((result-1)+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}
