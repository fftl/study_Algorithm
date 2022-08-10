package com.bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_01158_S4_요세푸스문제 {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> q = new LinkedList<>();
		
		//처음 사람들? 데이터를 queue에 넣어줍니다.
		for (int i = 1; i <=n; i++) {
			q.offer(i);
		}
		
		int nowK = 0;
		while(!q.isEmpty()) {
			nowK++;
			//nowK 가 k와 같다면 해당 사람을 꺼내주고, 아닐경우 뒤로 옮겨줍니다.
			if(nowK == k) {
				if(q.size()!=1) sb.append(q.poll()+", ");
				else sb.append(q.poll()+">");
				nowK = 0;
			} else {
				q.offer(q.poll());
			}
		}
		
		System.out.println(sb.toString().trim());
		
		sc.close();
		
	}

}
