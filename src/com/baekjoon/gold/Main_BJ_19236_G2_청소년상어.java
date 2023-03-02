package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_19236_G2_청소년상어 {
	
	//주어지는 방향은 1 부터이니까 주어지는 방향-1 을 해야 합니다.
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		sc.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());
	}
}
