package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01173_B2_운동 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int X = m;
		int e = 0;
		int t = 0;
		//N만큼 운동을 하는데 걸리는 최소 시간
		while(true){
			if(e==N) break;

			if(X+T<=M){
				X = X+T;
				e++;
				t++;
			} else {
				if(X-R>m){
					X = X-R;
				} else {
					if(X == m){
						System.out.println(-1);
						return;
					}else{
						X = m;
					}
				}
				t++;
			}
		}

		System.out.println(t);
	}
}
