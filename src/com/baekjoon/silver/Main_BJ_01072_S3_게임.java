package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_01072_S3_게임 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int start = (int) ((long) Y * 100 / X);

		if(start >= 99){
			System.out.println(-1);
			return;
		}

		int s = 0;
		int e = 1000000000;
		int mid;
		int result = -1;
		int next;
		while(s<=e){
			mid = (s+e)/2;
			next = (int) ((long) (Y+mid) * 100 / (X+mid));

			if(next > start){
				e = mid-1;
				result = mid;
			} else {
				s = mid+1;
			}
		}

		System.out.println(result);
	}
}
