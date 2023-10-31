package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_02605_B2_줄세우기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();
		int num = 1;
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(i==0) arr.add(1);
			else{
				arr.add(arr.size()-now, num);
			}
			num++;
		}

		StringBuilder sb = new StringBuilder();
		for(int res : arr){
			sb.append(res+" ");
		}

		System.out.println(sb.toString().trim());
	}
}
