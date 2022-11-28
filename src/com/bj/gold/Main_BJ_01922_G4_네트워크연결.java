package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_01922_G4_네트워크연결 {

	static class Line{
		int s;	//start
		int e;	//end
		int w;	//weight
		
		public Line(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}
	
	static Line[] lines;
	static int[] com;
	
	static void make() {
		for (int i = 0; i < com.length; i++) {
			com[i] = i;
		}
	}
	
	static int find(int a) {
		if(com[a] == a) return a;
		return com[a] = find(com[a]);
	}
	
	static boolean union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		if(roota == rootb) return false;
		
		com[rootb] = roota;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		com = new int[N+1];
		make();
		
		lines = new Line[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			lines[i] = new Line(s, e, w);
		}
		
		//가중치를 순서로 오름차순을 해주었습니다.
		Arrays.sort(lines, new Comparator<Line>() {
			@Override
			public int compare(Line o1, Line o2) {
				return o1.w-o2.w;
			}
		});
		
		int result = 0;
		int cnt = 0;
		for (Line l : lines) {
			if(union(l.s, l.e)) {
				result += l.w;
				cnt++;
			}
			if(cnt==N-1) break;
		}
		
		System.out.println(result);
		
	}
}
