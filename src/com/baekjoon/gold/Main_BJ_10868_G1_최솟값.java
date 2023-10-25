package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_BJ_10868_G1_최솟값 {

	static int N, M;
	static int[] nums;
	static TreeSet<Integer> sort;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		sort = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sort.add(nums[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;

			Set<Integer> set = new HashSet<>();
			for (int j = s; j <= e; j++) {
				set.add(nums[j]);
			}

			for (int min : sort){
				if(set.contains(min)){
					sb.append(min+"\n");
					break;
				}
			}
		}

		System.out.println(sb.toString().trim());


	}
}
