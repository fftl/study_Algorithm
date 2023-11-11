package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//순서가 존재하는 그래프는 위상정렬로 풀어야한다!?
//위상정렬은 대부분 다양한 답이 나올 수 있지만,
//해당 문제는 가능하면 가장 쉬운 문제를 풀어야 한다는 조건을 주어서
//하나의 답이 나올 수 있게 만들어 놓은것 같다.
public class Main_BJ_01766_G2_문제집 {
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//결과를 담아줄 sb
		StringBuilder sb = new StringBuilder();
		
		//각 문제가 몇번의 단계를 거쳐야 하는지 담아줄 int[] 배열
		int[] check = new int[N+1];
		
		//각 번호의 선행문제가 어떤 문제들인지 담아줄 arrList
		List<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 0; i <= N; i++) arr.add(new ArrayList<>());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			check[b]++;
			
			arr.get(a).add(b);
		}
		
		//시작은 우선순위 큐를 만들어서 선행 문제가 없는 애들을 먼저 담아줍니다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if(check[i] == 0) pq.add(i);
		}
		
		//큐를 꺼내면서 이번 큐에서 갈수 있는(이번 뎁스에서) 애들을 돌면서 단계를 감소시켜줍니다.
		//그리고 단계가 0 이 된 문제는 우선순위 큐에 넣어줍니다.
		while(!pq.isEmpty()) {
			int now = pq.poll();
			
			//q에서 꺼내지는 순서가 답이니까 담아줍니다.
			sb.append(now+" ");
			
			//이번 문제를 선행 조건으로 가지고있는 문제들을 가져옵니다.
			ArrayList<Integer> list = arr.get(now);
			
			//해당 문제의 check(선행문제 수를 감소시켜준 뒤) 만약 0이 되었다면
			//pq에 추가시켜줍니다.
			for (int i = 0; i < list.size(); i++) {
				check[list.get(i)]--;
				if(check[list.get(i)] == 0) {
					pq.add(list.get(i));
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
