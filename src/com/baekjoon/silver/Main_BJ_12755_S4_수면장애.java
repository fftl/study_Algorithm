package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_12755_S4_수면장애 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int now = 1;
		int index = 0;
		int num = 0;
		int cha = 0;
		while(index<n) {
			index += Integer.toString(now).length();
			if(index>=n){
				num = now;
				cha = index-n;
				break;
			}
			now++;
		}
		
		String last = Integer.toString(num);
		System.out.println(last.charAt(last.length()-(1+cha)));
	}
}
