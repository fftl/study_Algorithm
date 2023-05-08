package com.baekjoon.platinum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_20541_P5_앨범정리 {
	
	static Alb alb;
	static Alb now;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		alb = new Alb("album");
		now = alb; 
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			String value = st.nextToken();
		}
	}
	
	static void command(String key, String value) {
		if(key.equals("mkalb")) {
			if(now.has.contains(value)) sb.append("duplicated album name\n");
			else {
				now.ormAlb.add(new Alb(value));
				now.nerimAlb.add(new Alb(value));
			}
		} else if(key.equals("rmalb")){
			if(value.equals("-1")) {
				if(!now.has.isEmpty()) {
					
				}
			} else if(value.equals("0")) {
				
			} else if(value.equals("1")) {
				
			} else {
				
			}
			
		} else if(key.equals("insert")){
			
		} else if(key.equals("delete")){
			
		} else if(key.equals("ca")){
		}
	}
	
	static class Alb{
		String name;
		HashSet<String> has = new HashSet<>();
		PriorityQueue<Alb> ormAlb = new PriorityQueue<>();
		PriorityQueue<Alb> nerimAlb = new PriorityQueue<>(Collections.reverseOrder());

		PriorityQueue<String> ormPhoto = new PriorityQueue<>();
		PriorityQueue<String> nerimPhoto= new PriorityQueue<>(Collections.reverseOrder());
		
		public Alb(String name) {
			super();
			this.name = name;
		}
		
	}
}
