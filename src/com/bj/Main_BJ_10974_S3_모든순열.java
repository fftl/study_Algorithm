package com.bj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_10974_S3_모든순열 {
	static int n;
	static boolean[] visited;
	static StringBuilder sb;
	
	static void perm(int cnt){
		if(cnt == n) {
			System.out.println(Arrays.toString(visited));
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{

		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		visited = new boolean[n+1];
		
		perm(0);
		
		sc.close();
	}

}
