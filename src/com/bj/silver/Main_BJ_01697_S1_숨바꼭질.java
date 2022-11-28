package com.bj.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_01697_S1_숨바꼭질 {

	public static void main(String[] args) throws Exception{

		//데이터 입력받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		//n이 k보다 큰 경우 -1 을 반복하는 법 밖에 없음
		if(n>k) {
			System.out.println(n-k);
			sc.close();
			return;
		}
		
		//n과 k가 같은 경우 찾을 필요가 없음
		if(n==k) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		//bfs를 통해서 답을 찾아주었습니다.
		int depth = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		visited[n] = true;
 		q.add(n);
		
 		run : while(!q.isEmpty()) {
 			depth++;
 
 			int size = q.size(); //queue의 size 만큼만 poll을 해주어 새로 들어온 데이터는 꺼내지지 않도록 합니다.
 			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				
				//연산 이후의 값이 범위 안에 존재하며 방문하지 않은 숫자만 queue에 담아줍니다.
				//그러다 다음수가 k와 동일하다면 탐색을 바로 멈춰줍니다.
				if(0<= temp+1 && temp+1<100001 && !visited[temp+1]) {
					if(temp+1 == k) break run;
					q.add(temp+1);
					visited[temp+1] = true;
				}
				if(0<= temp-1 && temp-1<100001 && !visited[temp-1]) {
					if(temp-1 == k) break run;
					q.add(temp-1);
					visited[temp-1] = true;
				}
				if(0<= temp*2 && temp*2<100001 && !visited[temp*2]) {
					if(temp*2 == k) break run;
					q.add(temp*2);
					visited[temp*2] = true;
				}
			}
 		}
 		
 		System.out.println(depth);
		sc.close();
		
	}
}
