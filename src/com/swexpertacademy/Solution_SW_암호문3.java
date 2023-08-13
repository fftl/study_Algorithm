package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_SW_암호문3 {

	static int size;
	static ArrayList<Integer> pass;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++)
		{
			sb.append("#"+tc+" ");
			size = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			pass = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				pass.add(Integer.parseInt(st.nextToken()));
			}

			int cmd = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cmd; i++) {
				char c = st.nextToken().charAt(0); //명령어를 꺼내줍니다.

				if(c=='I'){
					insert(st);
				} else if(c=='D'){
					delete(st);
				} else {
					add(st);
				}
			}

			for (int i = 0; i < 10; i++) {
				if(i==9){
					sb.append(pass.get(i)+"\n");
				} else {
					sb.append(pass.get(i)+" ");
				}
			}
		}
		System.out.println(sb.toString().trim());
	} //main

	static void insert(StringTokenizer st){
		int s = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());

		Stack<Integer> sta = new Stack<>();
		for (int i = 0; i < cnt; i++) {
			sta.add(Integer.parseInt(st.nextToken()));
		}

		while(!sta.isEmpty()){
			pass.add(s, sta.pop());
		}
	}

	static void delete(StringTokenizer st){
		int s = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < cnt; i++) {
			pass.remove(s+1);
		}
	}

	static void add(StringTokenizer st){
		int cnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < cnt; i++) {
			pass.add(Integer.parseInt(st.nextToken()));
		}
	}
}
