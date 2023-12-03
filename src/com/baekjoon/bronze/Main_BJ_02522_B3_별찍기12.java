package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_02522_B3_별찍기12 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<String> st = new Stack<>();
		for (int i = 1; i <= n; i++) {
			String now = "";
			for (int j = 0; j < i; j++) {
				now = now+"*";
			}

			for (int j = 0; j < n-i; j++) {
				now = " "+now;
			}
			System.out.println(now);
			if(i==n) continue;
			st.add(now);
		}

		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}
}
