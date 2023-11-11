package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01712_B2_손익분기점 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		//한대 생산 비용이 노트북 가격보다 크다면, 아무리 많이 만들더라도
		//손익 분기점을 넘을 수 없습니다.
		if(b>=c) {
			System.out.println(-1);
			return;
		}
		
		//그리고 손익분기점을 넘을 수 있다면 노트북 비용/한대 만드는 비용의 값을 몇번 해야
		//고정 비용을 넘을 수 있는 지를 판단하면 되기에 고정비용 /위의 값을 해주어 답을 구했습니다.
		System.out.println(a/(c-b)+1);
	}
}
