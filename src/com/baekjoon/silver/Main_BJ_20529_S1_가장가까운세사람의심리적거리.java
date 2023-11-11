package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//조합을 이용해서? 하기에는 10만의 횟수가 걸렸다.
//가장 심리적 거리가 가까우려면 같은 MBTI의 사람 세명을 찾는 것이라고 볼 수 있다.
//MBTI를 정렬한담에 하나씩 살펴보면 어떨까 싶다?
public class Main_BJ_20529_S1_가장가까운세사람의심리적거리 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < tc; t++) {
			int min = Integer.MAX_VALUE;
			int len = Integer.parseInt(br.readLine());
			
			if(len > 32) {
				sb.append(0+"\n");
				st = new StringTokenizer(br.readLine());
				continue;
			}
			
			String[] arr = new String[len];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len; i++) {
				arr[i] = st.nextToken();
			}
			
			for (int i = 0; i < len; i++) {
				for (int j = i+1; j < len; j++) {
					for (int k = j+1; k < len; k++) {
						min = Math.min(min, check(arr[i], arr[j], arr[k]));
					}
				}
			}
			sb.append(min+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}
	
	
	
	static int check(String a, String b, String c) {
		int valA = 0;
		int valB = 0;
		int valC = 0;
		
		for (int i = 0; i < 4; i++) {
			if(a.charAt(i) != b.charAt(i)) valA++;
			if(b.charAt(i) != c.charAt(i)) valB++;
			if(a.charAt(i) != c.charAt(i)) valC++;
		}
		
		return valA+valB+valC;
	}
}
