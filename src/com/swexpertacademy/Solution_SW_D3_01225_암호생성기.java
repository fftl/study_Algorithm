package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D3_01225_암호생성기 {
	static StringBuilder sb;
	
	static void print(int tc, Queue<Integer> q) {
		sb.append("#"+tc+" ");
		for (int i = 0; i < 8; i++) {
			sb.append(q.poll()+" ");
		}
		sb.append("\n");
	}

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/sw_input_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		for (int i = 1; i <= 10; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[8];
			Queue<Integer> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < nums.length; j++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int[] minus = {1, 2, 3, 4, 5};
			int idx = 5;
			while(true) {
				if(q.peek() - minus[idx%5] <= 0) break;
				int num = q.poll();
				q.offer(num-minus[idx%5]);
				idx++;
			}
			
			int num = q.poll();
			q.offer(0);
			print(i, q);
		}
		System.out.println(sb.toString().trim());
	}

}
