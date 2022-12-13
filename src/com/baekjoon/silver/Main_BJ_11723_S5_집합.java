package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_11723_S5_집합 {

	public static void main(String[] args) throws Exception{

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		//답의 출력값을 담을 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		//1~20까지의 수의 포함 여부만을 판단하면 되기 때문에 boolean 배열을 사용해 보았습니다.
		boolean[] S = new boolean[21];
		
		//명령어 수만큼 반복합니다.
		for (int i = 0; i < t; i++) {
			
			//명령어를 입력받고, all과 empty의 경우 숫자 입력이 존재하지 않기 때문에 그를
			//분류해주기 위해서 split을 이용한 입력을 받았습니다.
			String[] strs = br.readLine().split(" ");
			
			//add, check remove, toggle의 경우
			if(strs.length > 1) {
				String cmd = strs[0];
				int n = Integer.parseInt(strs[1]);
				
				if(cmd.equals("add")) {
					S[n] = true;
				} else if(cmd.equals("check")) {
					
					//boolean 배열 S를 이용해 데이터를 가지고 있는지 아닌지 확인합니다.
					if(S[n]) sb.append(1+"\n");
					else sb.append(0+"\n");
				} else if(cmd.equals("remove")) {
					S[n] = false;
				} else if(cmd.equals("toggle")) {
					S[n] = !S[n];
				}
				
			//all, empty의 경우 입니다. 
			} else {
				String cmd = strs[0];
				if(cmd.equals("all")) {
					for (int j = 1; j < 21; j++) S[j] = true;
				} else {
					for (int j = 1; j < 21; j++) S[j] = false;
				}
			}
		}
		
		//결과물 출력!
		System.out.println(sb.toString().trim());
	}
}
