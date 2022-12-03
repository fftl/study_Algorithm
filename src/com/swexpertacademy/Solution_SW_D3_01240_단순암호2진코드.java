package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D3_01240_단순암호2진코드 {
	public static void main(String args[]) throws IOException
	{
		System.setIn(new FileInputStream("res/input_1240.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			String str = "";
			for (int i = 0; i < n; i++) {
				str = br.readLine();
				if(str.contains("1")) {
					break;
				}
			}
			
			
			
			
			
		}
	}
}