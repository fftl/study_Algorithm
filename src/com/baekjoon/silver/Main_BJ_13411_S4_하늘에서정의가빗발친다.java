package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_13411_S4_하늘에서정의가빗발친다 {
	
	static class Robot{
		double len;
		int i;
		
		public Robot(int i, double len) {
			super();
			this.i = i;
			this.len = len;
		}
		@Override
		public String toString() {
			return "Robot [len=" + len +", i=" + i + "]";
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Robot[] robots = new Robot[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			double k = Double.parseDouble(st.nextToken());
			
			double len = Math.sqrt(x*x + y*y);
			robots[i] = new Robot(i+1, len/k);
		}
		
		Arrays.sort(robots, new Comparator<Robot>() {
			@Override
			public int compare(Robot o1, Robot o2) {
				if(o1.len != o2.len) {
					return Double.compare(o1.len, o2.len);
				} else {
					return o1.i-o2.i; 
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < robots.length; i++) sb.append(robots[i].i+"\n");
		
		System.out.println(sb.toString().trim());
	}
}
