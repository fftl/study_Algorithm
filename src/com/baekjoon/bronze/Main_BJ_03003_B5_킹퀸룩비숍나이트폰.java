package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_03003_B5_킹퀸룩비숍나이트폰 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		int[] base = new int[] {1,1,2,2,2,8};
		int[] result = new int[6];
		
		//base와의 차가 얼마인지를 확인해 result에 담아줍니다.
		for (int i = 0; i < 6; i++) {
			int now = sc.nextInt();
			if(base[i]>now) result[i] = base[i]-now;
			else if(base[i]<now) result[i] = -1*(now-base[i]);
			else result[i] = 0;
		}
		
		//결과값 만들기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]+" ");
		}
		
		System.out.println(sb.toString().trim());
		sc.close();
	}
}
