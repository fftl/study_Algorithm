package com.zdocuments.mock;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D0_00000_헌터 {

	static int N;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_헌터.txt")); // input 가져오기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
		}
	}

}
