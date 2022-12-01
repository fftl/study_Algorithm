package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10250_B3_ACM호텔 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int cnt = 1;
			int nowH = 0;
			int nowW = 1;
			while(cnt <= n) {
				if(nowH+1 <= h) nowH += 1;
				else {
					nowH = 1;
					nowW++;
				}
				cnt++;
			}
			
			String result = Integer.toString(nowH);
			if(nowW<10) result += "0"+nowW;
			else result += nowW;
			System.out.println(result);
		}
	}
}
