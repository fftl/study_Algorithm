package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_BJ_02592_B2_대표값 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxCnt = 0;
		int maxVal = 0;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			if(map.containsKey(n)){
				map.put(n, map.get(n)+1);
			} else {
				map.put(n, 1);
			}

			if(maxCnt<map.get(n)){
				maxVal = n;
				maxCnt = map.get(n);
			}

			sum += n;
		}
		System.out.println(sum/10);
		System.out.println(maxVal);
	}
}
