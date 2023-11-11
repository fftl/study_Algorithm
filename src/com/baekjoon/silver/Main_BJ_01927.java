package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BJ_01927_S2_최소힙 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//최소 힙 역할을 해줄 PriorityQueue를 만들어 주었습니다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringBuilder sb = new StringBuilder();
		
		//요구사항에 맞도록 입력 값이 자연수일경우 pq에 입력해주고
		//0일 경우에는 최소값을 출력하는 동작을 반복합니다.
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(br.readLine());
			if(now == 0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else sb.append(pq.poll()+"\n");
			} else {
				pq.add(now);
			}
		}
		
		//결과물 출력!
		System.out.println(sb.toString().trim());
	}
}
