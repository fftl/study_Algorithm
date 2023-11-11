package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_16165_S3_걸그룹마스터준석이 {
	static int N, M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		HashMap<String, String[]> group = new HashMap<>();
		HashMap<String, String> member = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String gr = br.readLine();
			int size = Integer.parseInt(br.readLine());
			group.put(gr, new String[size]);

			for (int j = 0; j < size; j++) {
				String name = br.readLine();
				group.get(gr)[j] = name;
				member.put(name, gr);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String now = br.readLine();
			int key = Integer.parseInt(br.readLine());
			if(key==1){
				sb.append(member.get(now)+"\n");
			} else {
				String[] nowGroup = group.get(now);
				Arrays.sort(nowGroup);
				for (int j = 0; j < nowGroup.length; j++) {
					sb.append(nowGroup[j]+"\n");
				}
			}
		}

		System.out.println(sb.toString().trim());
	}
}
