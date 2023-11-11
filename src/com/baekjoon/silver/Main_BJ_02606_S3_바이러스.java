package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_02606_S3_바이러스 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for (int i = 0; i <= n; i++) arr.add(new ArrayList<>());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		boolean[] check = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		check[1] = true;
		
		int result = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				ArrayList<Integer> nowArr = arr.get(now);
				for (int num : nowArr) {
					if(!check[num]) {
						check[num] = true;
						q.add(num);
						result++;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
