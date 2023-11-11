package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_01049_S4_기타줄 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> six = new ArrayList<>();
		ArrayList<Integer> one = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			six.add(a);
			one.add(b);
		}

		Collections.sort(six);
		Collections.sort(one);

		int sixA = six.get(0);
		int oneA = one.get(0);

		int result = 0;

		//일단 패키지가 더 쌀 경우
		if(sixA < 6 * oneA){

			//하나의 가격보다 패키지가 싸면 굳이 하나를 살 필요가 없다.
			if(sixA<=oneA){
				if(N%6 == 0){
					result += (N/6)*sixA;
				} else {
					result += (N/6)*sixA;
					result += sixA;
				}

			} else {
				if(N%6 == 0){
					result += (N/6)*sixA;
				} else {
					result += (N/6)*sixA;
					result += (N%6)*oneA < sixA ? (N%6)*oneA : sixA;
				}

			}
		//패키지가 더 싸지 않을경우?!
		} else {
			result += oneA*N;
		}

		System.out.println(result);
	}
}
