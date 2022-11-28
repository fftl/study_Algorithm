package com.bj.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_01525_G2_퍼즐2 {

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static boolean[] visited;
	
	static void visit(String s) {
		int n = Integer.parseInt(s);
		visited[n] = true;
	}
	
	static boolean check(String s) {
		if(s.equals("123456780")) return true;
		return false;
	}
	
	static int find(String s) {
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '0') {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringBuilder copy;
		
		for (int i = 0; i < 9; i++) {
			sb.append(sc.nextInt());
		}
		
		visited = new boolean[1000000000];
		visit(sb.toString());
		
		Queue<StringBuilder> q = new LinkedList<>();
		q.add(sb);
		int n = 0;
		run : while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				StringBuilder now = q.poll();
				if(check(now.toString())) {
					break run;
				}
				int idx = find(now.toString());
				int y = idx/3;
				int x = idx%3;
				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if(0<=ny && ny<3 && 0<=nx && nx<3) {
						copy = new StringBuilder(now.toString());
						char c = copy.charAt(ny*3+nx);
						copy.setCharAt(ny*3+nx, '0');
						copy.setCharAt(y*3+x, c);
						int num = Integer.parseInt(copy.toString());
						if(!visited[num]) {
							visited[num] = true;
							q.add(copy);
						}
					}
				}
			}
			n++;
		}
		
		if(n==32) System.out.println(-1);
		else System.out.println(n);
		sc.close();
		
	}
}
