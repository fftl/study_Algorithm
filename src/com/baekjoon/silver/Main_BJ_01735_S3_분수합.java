package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_01735_S3_분수합 {
	static boolean[] arr;
	static ArrayList<Integer> ck;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());

		int c1 = 0;
		int c2 = 0;

		c2 = a2*b2;
		c1 = (a1*b2) + (b1*a2);

		init();

		while(true){
			boolean nanum = false;
			for (int prime : ck) {
				boolean ck1 = false;
				boolean ck2 = false;

				if(c1%prime == 0) ck1 = true;
				if(c2%prime == 0) ck2 = true;

				if(ck1 && ck2){
					c1 /= prime;
					c2 /= prime;
					nanum = true;
					break;
				}
			}

			if(!nanum){
				break;
			}
		}

		System.out.println(c1 +" "+ c2);
	}

	static void init(){
		arr = new boolean[30001];
		arr[1] = true;
		ck = new ArrayList<>();

		for (int i = 2; i <= 30000; i++) {
			if(!arr[i]) {
				ck.add(i);
				for (int j = i+i; j <= 30000; j+=i) {
					arr[j] = true;
				}
			}
		}
	}
}
