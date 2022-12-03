package com.baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_02164_S4_카드2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n == 1) {
			System.out.println(1);
			sc.close();
			return;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.offer(i);
		}
		
		while(true) {
			q.poll();
			if(q.size()==1) {
				break;
			}
			
			int a = q.poll();
			q.offer(a);
		}
		
		System.out.println(q.peek());
		sc.close();
	}

}
