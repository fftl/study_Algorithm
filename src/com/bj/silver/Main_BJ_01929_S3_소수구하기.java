package com.bj.silver;

import java.util.Scanner;

public class Main_BJ_01929_S3_소수구하기 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int e = sc.nextInt();
		int end = 1000001;
		boolean[] check = new boolean[end];
		
		check[0] = check[1] = true;
		for (int i = 2; i*i < end; i++) {
			if(!check[i]) {
				for (int j = i*i; j < end; j+=i) check[j] = true;
			}
			
		}
		
		for (int i = s; i <= e; i++) {
			if(!check[i]) System.out.println(i);
		}
		
		sc.close();
	}
}
