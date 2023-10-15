package com.baekjoon.gold;

import java.util.Scanner;

public class Main_BJ_02668_G5_숫자고르기 {
	static int n;
	static int[] base, arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		base = new int[n+1];
		arr = new int[n+1];
		visited = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			base[i] = i;
			arr[i] = num;

			if(num==i) visited[i] = true;
		}
		sc.close();

		for (int i = 1; i <= n; i++) {
			boolean key = false;
			if(!visited[i]){
				boolean[] nowCheck = new boolean[n+1];
				nowCheck[i] = true;
				run(i, arr[i], nowCheck);
			}
		}

		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if(visited[i]) {
				cnt++;
				sb.append(i + "\n");
			}
		}

		System.out.println(cnt);
		System.out.println(sb.toString().trim());

	}

	static void run(int start, int now, boolean[] nowCheck){
		//사이클이 발생!
		if(start == now){
			visited[start] = true;
			trueCheck(start, arr[start]);
		} else {
			if(nowCheck[now]) return;

			nowCheck[now] = true;
			run(start, arr[now], nowCheck);
		}

	}

	static void trueCheck(int start, int now){
		if(start != now){
			visited[now] = true;
			trueCheck(start, arr[now]);
		}
	}
}
