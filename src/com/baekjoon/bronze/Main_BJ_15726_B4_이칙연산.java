package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//https://www.acmicpc.net/board/view/102490
public class Main_BJ_15726_B4_이칙연산 {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		
		if(((A * B) / C) > ((A / B) * C)) {
			System.out.println((int) ((A * B) / C));
		}else {
			System.out.println((int) ((A / B) * C));
		}
	}
}
