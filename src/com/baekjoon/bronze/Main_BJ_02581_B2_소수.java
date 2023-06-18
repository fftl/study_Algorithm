package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_02581_B2_소수 {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int res = 0;
		ArrayList<Integer> list = new ArrayList<>(); 
		r: for (int i = a; i <= b; i++) {
			for (int j = 2; j <= i/2; j++) {
				if(i%j == 0) {
					continue r;
				}
			}
			
			if(i==1) continue;
			
			list.add(i);
			res += i;
		}
		
		if(list.size() == 0) {
			System.out.println(-1);
		} else {
			System.out.println(res);
			System.out.println(list.get(0));
		}
	}
	
}
