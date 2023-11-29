package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_02979_B2_트럭주차 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] time = new int[101];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			for (int j = s; j < e; j++) {
				time[j]++;
			}
		}

		int result = 0;
		for (int i = 1; i < 101; i++) {
			if(time[i] == 1) result += a;
			else if(time[i] == 2) result += b*2;
			else if(time[i] == 3) result += c*3;
		}

		System.out.println(result);
	}
}
