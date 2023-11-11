package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_11653_B1_소인수분해 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[n+1];
		ArrayList<Integer> plist = new ArrayList<>();
		
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 2; i <= n; i++) {
			if(prime[i]) continue;
			plist.add(i);
			for (int j = i+i; j <= n; j += i) {
				prime[j] = true;
			}
		}
		
		while(true) {
			if(n==1) break;
			
			if(plist.contains(n)) {
				System.out.println(n);
				break;
			}
			
			for (int i = 0; i < plist.size(); i++) {
				if(n%plist.get(i) == 0) {
					n = n/plist.get(i);
					System.out.println(plist.get(i));
					break;
				}
			}
		}
	}
}
