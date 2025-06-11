package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_04195_G2_친구네트워크 {
	static int[] parent;
	static int[] level;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int t=0; t<tc; t++){
			int F = Integer.parseInt(br.readLine());

			parent = new int[F*2];
			level = new int[F*2];
			for (int i = 0; i < F*2; i++) {
				parent[i] = i;
				level[i] = 1;
			}

			int idx = 0;
			Map<String, Integer> map = new HashMap<>();
			for(int f=0; f<F; f++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				if(!map.containsKey(a)){
					map.put(a, idx++);
				}

				if(!map.containsKey(b)){
					map.put(b, idx++);
				}

				sb.append(union(map.get(a), map.get(b))+"\n");
			}

//			System.out.println(Arrays.toString(parent));
		}

		System.out.println(sb.toString().trim());
	}

	static int find(int x){
		if (x == parent[x]){
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	static int union(int x, int y){
		x = find(x);
		y = find(y);

		if(x != y){
			parent[y] = x;
			level[x] += level[y];
			level[y] = 1;
		}

		return level[x];
	}
}

