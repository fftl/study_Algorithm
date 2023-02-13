package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_01991_S1_트리순회 {
	static HashMap<Character, char[]> map = new HashMap<>();
	static String a, b, c;

	//전위 순회
	static void pre(char now){
		a+=now;
		if(map.get(now)[0] != '.'){
			pre(map.get(now)[0]);
		}

		if(map.get(now)[1] != '.'){
			pre(map.get(now)[1]);
		}
	}

	//중위 순회
	static void cen(char now){
		if(map.get(now)[0] != '.'){
			cen(map.get(now)[0]);
		}

		b += now;

		if(map.get(now)[1] != '.'){
			cen(map.get(now)[1]);
		}
	}

	//후위 순회
	static void aft(char now){
		if(map.get(now)[0] != '.'){
			aft(map.get(now)[0]);
		}

		if(map.get(now)[1] != '.'){
			aft(map.get(now)[1]);
		}

		c += now;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		//map을 만들어준 뒤
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char now = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			map.put(now, new char[]{left, right});
		}

		a = "";
		b = "";
		c = "";

		//A부터 시작하는 각각의 순회를 재귀를 이용해서 실행합니다.
		pre('A');
		cen('A');
		aft('A');

		//각각의 결과값 출력!
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
