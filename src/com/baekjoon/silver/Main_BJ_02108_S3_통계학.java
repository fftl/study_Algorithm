package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main_BJ_02108_S3_통계학 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[] arr = new int[t];
		double[] dArr = new double[t];
		for (int i = 0; i < t; i++) {
			String s = br.readLine();
			arr[i] = Integer.parseInt(s);
			dArr[i] = Double.parseDouble(s);
		}
		
		Arrays.sort(arr);
		
		double a = 0;
		for (int i = 0; i < dArr.length; i++) {
			a += dArr[i];
		}
		//산술평균
		System.out.println(Math.round(a/t));
		
		//중앙값
		System.out.println(arr[arr.length/2]);
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		int max = 0;
		ArrayList<Integer> res = new ArrayList<>();
		for (int i:map.keySet()) {
			if(max<map.get(i)) {
				max = map.get(i);
				res.clear();
				res.add(i);
			} else if(max==map.get(i)) {
				res.add(i);
			}
		}
		Collections.sort(res);
		if(res.size()>1) {
			System.out.println(res.get(1));
		} else {
			System.out.println(res.get(0));
		}
		
		System.out.println(arr[arr.length-1] - arr[0]);
	}
}
