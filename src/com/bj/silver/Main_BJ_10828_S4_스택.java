package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_10828_S4_스택 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < t; i++) {
			String[] strs = br.readLine().split(" ");
			if(strs.length>1) {
				stack.add(Integer.parseInt(strs[1]));
			} else {
				if(strs[0].equals("top")) {
					sb.append(stack.peek()+"\n");
				} else if(strs[0].equals("size")) {
					sb.append(stack.size()+"\n");
				} else if(strs[0].equals("empty")) {
					if(stack.empty()) sb.append(1+"\n");
					else sb.append(0+"\n");
				} else if(strs[0].equals("pop")) {
					if(!stack.empty()) sb.append(stack.pop()+"\n");
					else sb.append(-1+"\n");
				}
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
