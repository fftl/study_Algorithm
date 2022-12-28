package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_01918_G2_후위표기식 {
	
	static int priority(char op) {
		if(op == '(' || op ==')') {
			return 0;
		} else if (op == '+' || op == '-') {
			return 1;
		} else if (op == '*' || op == '/') {
			return 2;
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);

			switch (now) {
			case '+':
			case '-':
			case '*':
			case '/':
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
					sb.append(stack.pop());
				}
				stack.add(now);
				break;
			case '(':
				stack.add(now);
				break;
			case ')':
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				sb.append(now);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString().trim());
	}
}