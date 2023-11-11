package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_02490_B3_윳놀이 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int num = 0;
			
			num += Integer.parseInt(st.nextToken());
			num += Integer.parseInt(st.nextToken());
			num += Integer.parseInt(st.nextToken());
			num += Integer.parseInt(st.nextToken());
			
			if(num==0)System.out.println("D");
			else if(num==3) System.out.println("A");
			else if(num==2) System.out.println("B");
			else if(num==1) System.out.println("C");
			else System.out.println("E");
		}
	}
}
