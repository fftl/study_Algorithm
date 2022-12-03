package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_07568_S5_덩치 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		int[][] data = new int[t][2];	//입력으로 주어지는 몸무게, 키의 정보를 담을 이차원 배열 입니다.
		
		//for문을 통해서 몸무게 키 데이터를 data 배열에 알맞게 넣어줍니다.
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int kg = Integer.parseInt(st.nextToken());
			int cm = Integer.parseInt(st.nextToken());
			
			data[i][0] = kg;
			data[i][1] = cm;
		}
		
		//이중for문을 돌면서 현재 i번째의 사람보다 덩치가 큰 사람의 수를 세어 StringBuilder에 담아줍니다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int cnt = 0;
			for (int j = 0; j < t; j++) {
				if(i==j) continue;
				if(data[i][0]<data[j][0] && data[i][1]<data[j][1]) {
					cnt++;
				}
			}
			sb.append((cnt+1)+" ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
