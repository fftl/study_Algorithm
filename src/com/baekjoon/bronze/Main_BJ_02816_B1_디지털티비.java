package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_02816_B1_디지털티비 {

	static final String ONE = "KBS1";
	static final String TWO = "KBS2";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();

		for(int i=0; i<n; i++){
			list.add(br.readLine());
		}

		int scope = 0;

		StringBuilder sb = new StringBuilder();

		while(!list.get(0).equals(ONE)){
			if(!list.get(scope).equals(ONE)){
				sb.append(1);
				scope++;
			} else {
				list.remove(scope);
				list.add(scope-1, ONE);
				sb.append(4);
				scope--;
			}
		}

//		System.out.println(scope);
//		System.out.println(list);

		while(!list.get(1).equals(TWO)){
//			System.out.println("now scpoe : "+scope);
			if(!list.get(scope).equals(TWO)){
				sb.append(1);
				scope++;
			} else {
				list.remove(scope);
				list.add(scope-1, TWO);
				sb.append(4);
				scope--;
			}
		}

		System.out.println(sb.toString());
	}
}
