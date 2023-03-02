package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_20055_G5_컨베이어벨트위의로봇 {
	static int N, K, zeroCnt;
	static ArrayList<Integer> arr;
	static ArrayList<Boolean> rb;

	public static void main(String[] args) throws Exception{
		
		//ArrayList를 사용, 로봇이 있는 위치는 boolean 배열?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		zeroCnt = 1;
		
		arr = new ArrayList<>();
		rb = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= 2*N; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr.add(now);
			rb.add(false);
		}

		while(zeroCnt<K) {
			//1번 과정
			int lastN = arr.remove(arr.size()-1);
			boolean lastB = rb.remove(rb.size()-1);
			
			arr.add(0, lastN);
			rb.add(0, lastB);
			
			//2번 과정 0~N-1까지의 
			for (int i = N-2; i >= 0; i--) {
				if(rb.get(i)) { //만약 로봇이 있다면 다음
					
				}
			}
		}
	}
}
