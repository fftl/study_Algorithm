package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SW_D3_09229_한빈이와SpotMart {
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/sw_input_9229.txt")); //input 가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); 
			int m = Integer.parseInt(st.nextToken()); 
			int[] arr = new int[n]; 
			
			//배열을 채워줍니다.
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int result = 0;
			//이중포문을 이용해서 두개를 선택하는 조합을 찾아 최대값을 구합니다.
			for (int i = 0; i < arr.length; i++) {
				for (int j = i+1; j < arr.length; j++) {
					int now = arr[i]+arr[j];
					if(result<now && now<=m) {
						result = now;
					}
				}
			}
			
			if(result == 0) sb.append(-1);
			else sb.append(result);
			
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString().trim());
	}
}