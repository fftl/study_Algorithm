package com.bj.gold;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//5 17
public class Main_BJ_13913_G4_숨바꼭질4 {
	
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[100001];
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//수빈이가 더 큰 경우는 이 방법밖에 없음
		if(N>K) {
			sb.append(N-K+"\n");
			while(N>=K) {
				sb.append(N+" ");
				N--;
			}
			System.out.println(sb.toString().trim());
			return;
		}
		
		if(N==K) {
			sb.append(0+"\n");
			sb.append(N);
			System.out.println(sb.toString().trim());
			return;
		}
		
		Queue<ArrayList<Integer>> que = new LinkedList<>();
		ArrayList<Integer> init = new ArrayList<>();
		init.add(N);
		
		visited[N] = true;
		que.add(init);
		
		ArrayList<Integer> result = new ArrayList<>();
		int depth = 0;
		boolean find = true;
		while(find) {
			System.out.println(que.toString());
			int size = que.size();
			for (int i = 0; i < size; i++) {
				ArrayList<Integer> arr = que.poll(); 
				int now = arr.get(depth);
				
				if(0<=now+1 && now+1<=100000 && !visited[now+1]) {
					ArrayList<Integer> nowArr = (ArrayList<Integer>) arr.clone();
					if(now+1 == K) {
						find = false;
						nowArr.add(now+1);
						result = nowArr;
						break;
					} else {
						visited[now+1] = true;
						nowArr.add(now+1);
						que.add(nowArr);
					}
				}
				
				if(0<=now-1 && now-1<=100000 && !visited[now-1]) {
					ArrayList<Integer> nowArr = (ArrayList<Integer>) arr.clone();
					if(now-1 == K) {
						find = false;
						nowArr.add(now-1);
						result = nowArr;
						break;
					} else {
						visited[now-1] = true;
						nowArr.add(now-1);
						que.add(nowArr);
					}
				}
				
				if(0<=now*2 && now*2<=100000 && !visited[now*2]) {
					ArrayList<Integer> nowArr = (ArrayList<Integer>) arr.clone();
					if(now*2 == K) {
						find = false;
						nowArr.add(now*2);
						result = nowArr;
						break;
					} else {
						visited[now*2] = true;
						nowArr.add(now*2);
						que.add(nowArr);
					}
				}
			}
			depth++;
		}
		
		sb.append(depth+"\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		
		System.out.println(sb.toString().trim());
		sc.close();
	}

}
