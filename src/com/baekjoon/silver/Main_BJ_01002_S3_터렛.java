package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BJ_01002_S3_터렛 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			if(x1==x2 && y1==y2 && r1==r2){
				System.out.println(-1);
				continue;
			}

			int distance = (int)(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));

			if(distance > Math.pow(r1+r2, 2)){
				System.out.println(0);
			}
			else if(distance == Math.pow(r1+r2, 2)){
				System.out.println(1);
			}
			else if(distance < Math.pow(r1-r2, 2)){
				System.out.println(0);
			}
			else if(distance == Math.pow(r1-r2, 2)){
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}
}
