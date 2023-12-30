package com.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_04948_S2_베르트랑공준 {
	static boolean[] prime;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		prime = new boolean[(123456*2)+1];
		prime[0] = prime[1] = true;

		for (int i = 2; i < (123456*2)+1; i++) {
			if(prime[i] == false){
				for (int j = i+i; j < (123456*2)+1; j+=i) {
					prime[j] = true;
				}
			}
		}

		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;

			int cnt = 0;
			for (int i = n+1; i <= n*2; i++) {
				if(!prime[i]) cnt++;
			}

			sb.append(cnt+"\n");
		}

		System.out.println(sb.toString().trim());
	}
}
