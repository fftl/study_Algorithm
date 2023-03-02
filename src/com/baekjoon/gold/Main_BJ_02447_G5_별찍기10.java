package com.baekjoon.gold;

import java.util.Scanner;

public class Main_BJ_02447_G5_별찍기10 {
	
	static int N;
	static char[][] stars;
	
	public static void run(int n) {
		
		//별의 크기가 1이라면 run을 종료합니다.
		if(n==1) return;
		
		//n의 값에 따라서 반복하는 이중 포문 입니다.
		for (int i = 0; i < N; i+=n) {
			for (int j = 0; j < N; j+=n) {
				
				//바깥의 이중포문을 돌며 가운데 부분이 온다면 해당 부분의 별만 공백으로 지워줍니다.
				for (int i2 = i+(n/3); i2 < i+(n/3)+(n/3); i2++) {
					for (int j2 = j+(n/3); j2 < j+(n/3)+(n/3); j2++) {
						stars[i2][j2] = ' ';
					}
				}
			}
		}
		
		run(n/3);
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		//N x N 의 별의 틀을 char를 이용해서 만들어줍니다.
		stars = new char[N][N];
		
		//모든 별이 존재하는 모양으로 별을 찍어줍니다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				stars[i][j] = '*';
			}
		}
		
		//run 실행!
		run(N);
		
		//별의 모양을 완성했으니 출력을 위한 StringBuilder를 만듭니다.
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String now = "";
			for (int j = 0; j < N; j++) {
				now += stars[i][j];
			}
			sb.append(now+"\n");
		}
		
		//출력!
		System.out.println(sb.toString().trim());
		sc.close();
	}
}
