package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D4_08458_원점으로집합 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_8458.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				int k = Math.abs(y) + Math.abs(x);
				arr[i] = k;
			}
			
			System.out.println(Arrays.toString(arr));
		}
		
		
	}

}
