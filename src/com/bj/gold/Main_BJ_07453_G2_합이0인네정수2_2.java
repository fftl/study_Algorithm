package com.bj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_07453_G2_합이0인네정수2_2 {

	//두개씩 합쳐서 두개의 배열으로 확인하면 된다? 이게 왜 가능??
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		long[] ab = new long[N];
		long[] cd = new long[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ab[i] = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
			cd[i] = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
		}
		
		System.out.println(Arrays.toString(ab));
		System.out.println(Arrays.toString(cd));
		
		Arrays.sort(ab);
		Arrays.sort(cd);
		System.out.println("---------------------");
		System.out.println(Arrays.toString(ab));
		System.out.println(Arrays.toString(cd));
	}
}
