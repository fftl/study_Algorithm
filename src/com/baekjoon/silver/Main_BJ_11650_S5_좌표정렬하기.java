package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_11650_S5_좌표정렬하기 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		ArrayList<int[]> arr = new ArrayList<>();
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr.add(new int[] {x, y});
		}
		
		Collections.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[0] != b[0]) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			}
		});
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i)[0]+ " " + arr.get(i)[1]);
		}
	}
}
