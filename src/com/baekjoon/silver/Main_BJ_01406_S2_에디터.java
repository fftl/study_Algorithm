package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_BJ_01406_S2_에디터 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		LinkedList<Character> list = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		
		int cs = list.size(); //0~len 까지를 가진다 시작은 len으로 가장 뒤에서 시작함.
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String cmd = br.readLine();
			String[] cmds = cmd.split(" ");
			
			if(cmds.length == 1) {
				if(cmds[0].equals("L")) {
					if(cs == 0) continue;
					else {
						cs--;
					}
				} else if(cmds[0].equals("D")) {
					if(cs== list.size()) continue;
					else {
						cs++;
					}
				} else {
					if(cs==0 ||  list.size() ==0) continue;
					list.remove(cs-1);
					cs--;
				}
				
			} else {
				list.add(cs, cmds[1].charAt(0));
				cs++;
			}
			
//			System.out.println("현재 커서 >> "+cs+ "// 현재 문자열" + list.toString());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) sb.append(list.get(i)); 
		System.out.println(sb.toString());
	}
}
