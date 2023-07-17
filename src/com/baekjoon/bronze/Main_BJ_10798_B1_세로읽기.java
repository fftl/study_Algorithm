package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_10798_B1_세로읽기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<StringBuilder> arr = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			arr.add(new StringBuilder());
		}
		
		for (int i = 0; i < 5; i++) {
			String now = br.readLine();
			for (int j = 0; j < now.length(); j++) {
				arr.get(j).append(now.charAt(j));
			}
		}
		
		for (int i = 0; i < 15; i++) {
			if(arr.get(i).length()>0) System.out.print(arr.get(i));
		}
	}
}
