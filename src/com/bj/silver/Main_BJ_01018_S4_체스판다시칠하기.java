package com.bj.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01018_S4_체스판다시칠하기 {

	static char change(char val) {
		if(val == 'B') return 'W';
		else return 'B';
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[y][x];
		for (int i = 0; i < y; i++) {
			String now = br.readLine();
			arr[i] = now.toCharArray();
		}
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= y-8; i++) {
			for (int j = 0; j <= x-8; j++) {
				
				int n = 0;
				char val = 'W';
				for (int i2 = i; i2 < 8+i; i2++) {
					for (int j2 = j; j2 < 8+j; j2++) {
						if(val != arr[i2][j2]) n++;
						val = change(val);
					}
					val = change(val);
				}
				result = Math.min(n, result);
				
				n = 0;
				val = 'B';
				for (int i2 = i; i2 < 8+i; i2++) {
					for (int j2 = j; j2 < 8+j; j2++) {
						if(val != arr[i2][j2]) n++;
						val = change(val);
					}
					val = change(val);
				}
				result = Math.min(n, result);
			}
		}
		
		System.out.println(result);
	}
}
