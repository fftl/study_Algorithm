package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main_BJ_02312_S3_수복원하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tc; i++) {
			int now = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();

			while(now > 1){
				for (int j = 2; j <= now; j++) {
					if(now%j==0){
						if(map.containsKey(j)){
							map.put(j, map.get(j)+1);
						} else {
							map.put(j, 1);
						}

						now /= j;
						break;
					}
				}
			}

			ArrayList<Integer> keys = new ArrayList<>();
			for (int k : map.keySet()){
				keys.add(k);
			}

			Collections.sort(keys);

			for (int key : keys){
				sb.append(key+" "+map.get(key)+"\n");
			}
		}

		System.out.println(sb.toString().trim());
	}
}
