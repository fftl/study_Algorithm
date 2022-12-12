package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11399_S4_ATM {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//시간의 합의 최소를 구하기 위해서는 시간이 적게 걸리는 사람부터 순서대로
		//인출하는 방법이 있습니다.
		Arrays.sort(arr);
		
		//총 걸리는 시간과
		//이번 사람이 기다린 시간을 담아줄 result와 time 입니다.
		int result = 0;
		int time = 0;
		
		for (int i = 0; i < n; i++) {
			result += time+arr[i]; //기다린 시간+이번 사람이 인출하는 시간을 더해줍니다.
			time+=arr[i];		   //시간을 쉽게 표현하기 위해서 time에 지속해서 더해줍니다.
		}
		
		//결과 출력!
		System.out.println(result);
	}
}
