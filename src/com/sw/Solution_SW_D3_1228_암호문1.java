package com.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SW_D3_1228_암호문1 {
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/sw_input_1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int cnt = Integer.parseInt(br.readLine()); //원본 암호문
			ArrayList<Integer> arr = new ArrayList<>(); 
			sb.append("#"+tc+" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < cnt; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
 			}
			
			int cmdCnt = Integer.parseInt(br.readLine()); //명령

			st = new StringTokenizer(br.readLine(), "I");
			for (int i = 0; i < cmdCnt; i++) {
				String[] data = st.nextToken().split(" ");
				int s = Integer.parseInt(data[1]);
				int ct = Integer.parseInt(data[2]);
				
				int[] now = new int[ct];
				
				for(int j=0; j<ct; j++) {
					arr.add(s+j,Integer.parseInt(data[3+j]));
				}
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(arr.get(i)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}
}