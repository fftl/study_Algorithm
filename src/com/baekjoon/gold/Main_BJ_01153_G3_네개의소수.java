package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_BJ_01153_G3_네개의소수 {
	static int n;
	static boolean[] isPrime;
	static int[] ans = new int[4];
	static List<Integer> prime;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		prime = new ArrayList<>();
		artaos();

		if(n<8) {
			System.out.println(-1);
			return;
		} else {
			//숫자가 짝수가 아니라면
			if(n%2 == 0){
				n -= 4;
				goldbach(n);
				ans[0] = ans[1] = 2;
			} else {
				n -= 5;
				goldbach(n);
				ans[0] = 2;
				ans[1] = 3;
			}
		}

		for (int i = 0; i < 4; i++) {
			System.out.println(ans[i]+" ");
		}
	}

	static void goldbach(int num){
		for (int i = 0; i < prime.size(); i++) {
			for (int j = 0; j < prime.size(); j++) {
				int sum = prime.get(i) + prime.get(j);
				if(sum == num){
					ans[2] = prime.get(i);
					ans[3] = prime.get(j);
					return;
				} else if(sum > num){
					break;
				}
			}
		}
	}

	static void artaos(){
		for (int i = 2; i*i <= n; i++) {
			if(isPrime[i]){
				for (int j = i*i; j <= n; j+=i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if(isPrime[i]) prime.add(i);
		}
	}
}
