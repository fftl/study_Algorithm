package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_01874_S2_스택수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int num = 1;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int nowN = arr[i];
			while(num<=nowN) {
				st.add(num);
				sb.append("+\n");
				num++;
				cnt++;
			}
			
			if(st.peek() == nowN) {
				st.pop();
				sb.append("-\n");
				cnt++;
			}
		}
		if(cnt == n*2) System.out.println(sb.toString().trim());
		else System.out.println("NO");
		
	}
}
