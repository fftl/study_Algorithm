package com.baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_11866_S5_요세푸스문제0 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int cnt = 1;
		while(!q.isEmpty()) {
			if(cnt == k) {
				cnt = 1;
				if(q.size() != 1) sb.append(q.poll()+", ");
				else sb.append(q.poll());
			} else {
				cnt++;
				int a = q.poll();
				q.add(a);
			}
		}
		sb.append(">");
		sc.close();
		
		System.out.println(sb.toString().trim());
	}
}
