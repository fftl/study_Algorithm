package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_BJ_10799_S2_쇠막대기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		
		//스택에 열린 괄호의 개수를 세어줍니다.
		//열린 괄호가 0이상인 상태에서 괄호쌍이 나오면 현재 열린괄호의 개수만큼 막대기를 세어줍니다.
		String next = str.replaceAll("\\(\\)", "a");
		
		System.out.println(next);
		
		ArrayList<Integer> arr = new ArrayList<>();
	
	}
}
