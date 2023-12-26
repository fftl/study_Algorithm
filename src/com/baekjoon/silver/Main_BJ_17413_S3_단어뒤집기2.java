package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_17413_S3_단어뒤집기2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		StringBuilder now = new StringBuilder();
		boolean flag = false;
		while(idx<str.length()){
			if(str.charAt(idx) == '<' || str.charAt(idx) == '>' || str.charAt(idx) == ' '){
				if(str.charAt(idx) == '<'){
					sb.append(reverse(now.toString()));
					now = new StringBuilder();
					now.append("<");
					flag = true;

				} else if(str.charAt(idx) == '>'){
					sb.append(now.toString()+str.charAt(idx));
					now = new StringBuilder();
					flag = false;

				} else {
					if(!flag){
						sb.append(reverse(now.toString()));
						now = new StringBuilder();
						sb.append(" ");
					} else {
						now.append(" ");
					}
				}
				idx++;
			} else {
				now.append(str.charAt(idx));
				idx++;
			}
		}
		sb.append(reverse(now.toString()));
		System.out.println(sb.toString());
	}

	static String reverse(String str){
		StringBuilder sb = new StringBuilder();
		for (int i = str.length()-1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString().trim();
	}
}
