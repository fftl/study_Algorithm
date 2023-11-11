package com.baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BJ_15711_G3_환상의짝궁 {
	static ArrayList<Integer> arr;
	static boolean[] primeCheck;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new ArrayList<>();
		primeCheck = new boolean[2000001];
		primeCheck[0] = true;
		primeCheck[1] = true;
		
		for (int i = 2; i < 2000001; i++) {
			if(!primeCheck[i]) {
				arr.add(i);
				for (int j = i+i; j < 2000001; j+=i) {
					primeCheck[j] = true;
				}
			}
		}
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			if(run(a,b)) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	public static boolean run(long a, long b) {
		long sum = a+b;
		if(sum<4) return false;
		else if(sum%2==0) return true;
		else {
			long l = sum - 2;
			if(l <= 2000000) {
				if(!primeCheck[(int) (l)]) return true;
				else return false;
			} else {
				for (int i = 0; i < arr.size(); i++) {
					if(l%arr.get(i) == 0) return false;
				}
				return true;
			}
		}
	}
}
