package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01920_S4_수찾기 {
	static int N, M;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] pocket = new int[N];
		for (int i = 0; i < N; i++) {
			pocket[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pocket);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			int result = Arrays.binarySearch(pocket, now);
			
			if(result>=0) System.out.println(1);
			else System.out.println(0);
		}
		
	}
}
