package com.bj.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_10974_S3_모든순열 {
	static int n;
	static boolean[] visited;
	static int[] numbers;
	static StringBuilder sb;
	
	static void perm(int cnt){
		if(cnt == n) {
			for(int i=0; i<numbers.length; i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = i;
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	//visited를 이용해서 방문처리를 이용한 순열을 구했습니다.
	public static void main(String[] args) throws Exception{

		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n+1];
		numbers = new int[n];
		
		perm(0);
		
		System.out.println(sb.toString().trim());
		sc.close();
	}

}
