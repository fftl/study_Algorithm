package com.bj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_1759_G5_암호만들기 {
	static int L, C;
	static ArrayList<Character> moem;
	static char[] data;
	static boolean[] visited;
	
	static boolean check(String s) {
		int moCnt = 0; //모음 개수
		int jaCnt = 0; //자음 개수
		for(int i=0; i<s.length(); i++) {
			if(moem.contains(s.charAt(i))) {
				moCnt++;
			} else {
				jaCnt++;
			}
		}
		
		if(moCnt >= 1 && jaCnt >=2) {
			return true;
		}
		
		return false;
	}
	
	static void comb(int cnt, int start) {
		if(cnt == L) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < data.length; i++) {
				if(visited[i]) sb.append(data[i]);
			}
			if(check(sb.toString())) {
				System.out.println(sb.toString());
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			comb(cnt+1, i);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		moem = new ArrayList<>();
		moem.add('a');
		moem.add('e');
		moem.add('i');
		moem.add('o');
		moem.add('u');
		
		data = new char[C];
		visited = new boolean[C];
		
		for (int i = 0; i < C; i++) {
			data[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(data);
		
		comb(0, 0);
		
		sc.close();
	}
}
