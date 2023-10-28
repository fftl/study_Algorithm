package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BJ_09881_S5_SkiCourseDesign {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(list);

		int res = 0;
		while(true){
			System.out.println(list);
			int min = list.get(0);
			int max = list.get(list.size()-1);

			list.remove(0);
			list.remove(list.size()-1);

			int cha = max-min;
			if(cha <= 17) {
				break;
			} else{
				int half = cha-17;
				if(half%2==0){
					half /= 2;
					res += half*half*2;
					list.add(min+half);
				} else {
					half /= 2;
					res += (half+1)*(half+1);
					res += half*half;

					list.add(min+half+1);
				}
				list.add(max-half);
			}

			Collections.sort(list);
		}

		System.out.println(res);

	}
}



