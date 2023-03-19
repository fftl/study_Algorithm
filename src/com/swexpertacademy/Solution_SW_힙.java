package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_힙 {
	
	static int[] heap;
	static int idx;
	
	public void add(int val) {
		int now = idx;
		int next = idx/2;
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++)
		{
			int n = Integer.parseInt(br.readLine());
			heap = new int[n+1];
			idx = 1;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				switch (cmd) {
				case 1:
					
					int val = Integer.parseInt(st.nextToken());
					if(idx == 1) {
						heap[idx] = val;
					} else {
						
					}
					
					break;
				case 2:
					
					break;
				}
			}
		}
	}
}
