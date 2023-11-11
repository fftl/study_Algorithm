package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_27172_G5_수나누기게임 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[] data = new int[n];
		int[] res = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(data[i]%data[j] == 0) {
					res[i]--;
					res[j]++;
				}
				else if(data[j]%data[i] == 0) {
					res[j]--;
					res[i]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i : res) {
			sb.append(i+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}