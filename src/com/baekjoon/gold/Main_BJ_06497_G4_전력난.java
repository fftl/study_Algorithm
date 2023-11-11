package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_06497_G4_전력난 {
	static int m, n;
	static int[] parents;
	
	static int find(int n) {
		if(parents[n] == n) return n;
		else return find(parents[n]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) parents[y] = x;
		else parents[x] = y;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m==0 && n==0) break;
			
			ArrayList<int[]> arr = new ArrayList<>();
			
			int all = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				all += z;
				
				arr.add(new int[] {x, y, z});
			}
			
			arr.sort(new Comparator<int[]>(){
				@Override
				public int compare(int[] a, int[] b) {
					return a[2]- b[2];
				}
			});
			
			parents = new int[m];
			for (int i = 0; i < m; i++) parents[i] = i;
			
			
			int res = 0;
			for (int i = 0; i < arr.size(); i++) {
				int[] now = arr.get(i);
				if(find(now[0]) != find(now[1])) {
					res += now[2];
					union(now[0], now[1]);
				}
			}
			sb.append(all-res+"\n");
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
