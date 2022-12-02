package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_BJ_10866_S4_덱 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < t; i++) {
			String[] str = br.readLine().split(" ");
			if(str.length>1) {
				if(str[0].equals("push_front")) list.addFirst(Integer.parseInt(str[1]));
				else list.addLast(Integer.parseInt(str[1]));
			} else {
				if(str[0].equals("pop_front")) {
					if(list.isEmpty()) sb.append(-1+"\n");
					else sb.append(list.pollFirst()+"\n");
					
				} else if(str[0].equals("pop_back")) {
					if(list.isEmpty()) sb.append(-1+"\n");
					else sb.append(list.pollLast()+"\n");
					
				} else if(str[0].equals("front")) {
					if(list.isEmpty()) sb.append(-1+"\n");
					else sb.append(list.peekFirst()+"\n");
					
				} else if(str[0].equals("back")) {
					if(list.isEmpty()) sb.append(-1+"\n");
					else sb.append(list.peekLast()+"\n");
					
				} else if(str[0].equals("size")) {
					sb.append(list.size()+"\n");
					
				} else if(str[0].equals("empty")) {
					if(list.isEmpty()) sb.append(1+"\n");
					else sb.append(0+"\n");
				} 
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}
