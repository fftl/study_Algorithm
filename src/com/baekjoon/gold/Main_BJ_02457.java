package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_02457_G3_공주님의정원 {
	
	static class Time{
		int start, end;

		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Time [start=");
			builder.append(start);
			builder.append(", end=");
			builder.append(end);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Time> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String sh = st.nextToken();
			String sm = st.nextToken();
			sm = Integer.parseInt(sm) < 10 ? "0"+sm : sm;
			String eh = st.nextToken();
			String em = st.nextToken();
			em = Integer.parseInt(em) < 10 ? "0"+em : em;
			list.add(new Time(Integer.parseInt(sh+sm), Integer.parseInt(eh+em)));
		}
		
//		System.out.println(list.toString());
		list.sort(new Comparator<Time>() {
			@Override
			public int compare(Time a, Time b) {
				if(a.start == b.start) {
					return b.end-a.end;
				} else {
					return a.start-b.start;
				}
			}
		});
//		System.out.println(list.toString());
		
		int max = 0, ans = 0;
		int start = 301;
		int idx = 0;
		while(start<1201) {
			boolean ch = false;
			for(int i=idx; i<n; i++) {
				
				if(list.get(i).start > start) break;
				if(list.get(i).start <= start && max<list.get(i).end) {
					max = list.get(i).end;
					idx = i+1;
					ch = true;
			
				}
			}
			
			if(ch) {
				start = max;
				ans++;
			} else break;
		}
		
		if(max<1201) System.out.println(0);
		else System.out.println(ans);
		
	}
}
