package com.baekjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_01759_G5_암호만들기 {
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
	
	//comb를 통해서 순서대로 조합을 찾아가며
	//암호의 개수에 도달했다면, check 메소드를 통해서 모음개수 자음개수를 확인하고 
	//최소 조건을 충족한다면  출력, 아니라면 스킵합니다.
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
		
		//모음 개수를 세어주기 위한 moem arrayList
		moem = new ArrayList<>();
		moem.add('a');
		moem.add('e');
		moem.add('i');
		moem.add('o');
		moem.add('u');
		
		data = new char[C];
		visited = new boolean[C];
		
		//data에 알파벳들을 담아줍니다.
		for (int i = 0; i < C; i++) {
			data[i] = sc.next().charAt(0);
		}
		
		//결론적으로 정렬된 문자열을 반환해야 하기 때문에 미리 정렬을 하고
		//조합을 만들어주었습니다.
		Arrays.sort(data);
		
		comb(0, 0);
		
		sc.close();
	}
}
