package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//간단한 사고력 문제입니다.
//직사각형의 네개의 점 중 세개를 주고
//나머지 한 점을 찾는 문제입니다.
//그래서 각각 x, y 좌표 중 하나씩만 등장한 것을 네번째 점에 할당해주면 됩니다.
public class Main_BJ_03009_B3_네번째점 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a3 = Integer.parseInt(st.nextToken());
		int b3 = Integer.parseInt(st.nextToken());
		
		int a4 = 0;
		int b4 = 0;
		
		if(a1==a2) a4 = a3;
		else if(a2==a3) a4 = a1;
		else a4 = a2;
		
		if(b1==b2) b4 = b3;
		else if(b2==b3) b4 = b1;
		else b4 = b2;
		
		System.out.println(a4+" "+b4);
	}
}
