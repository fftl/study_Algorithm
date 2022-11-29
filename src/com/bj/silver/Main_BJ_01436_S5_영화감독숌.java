package com.bj.silver;

import java.util.Scanner;

public class Main_BJ_01436_S5_영화감독숌 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		
		String base = "666";
		int num = 0;
		while(cnt!=n) {
			String now = Integer.toString(num);
			if(now.contains(base)) cnt++;
			num++;
		}
		
		System.out.println(num-1);
		sc.close();
	}
}