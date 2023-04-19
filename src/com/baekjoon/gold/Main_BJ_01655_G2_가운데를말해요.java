package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_01655_G2_가운데를말해요 {
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[] {1,2,3};
		int[] arr1 = new int[] {3,7,9};
		int[] arr2 = new int[] {2,11,3};
		int[] arr3 = new int[] {0,2,3};
		
		ArrayList<int[]> list = new ArrayList<>();
		list.add(arr);
		list.add(arr1);
		list.add(arr2);
		list.add(arr3);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
		}
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					if(o1[1] == o2[1]) {
						return o1[2]-o2[2]; 
					} else {
						return o1[1]-o2[1];
					}
				} else {
					return o1[0]-o2[0];
				}
			}
		});
		System.out.println("-----------------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
		}
	}
}
