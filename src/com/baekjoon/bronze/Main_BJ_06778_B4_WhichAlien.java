package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_06778_B4_WhichAlien {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		if(a>=3 && e<=4){
			System.out.println("TroyMartian");
		}
		if(a<=6 && e>=2){
			System.out.println("VladSaturnian");
		}
		if(a<=2 && e<=3){
			System.out.println("GraemeMercurian");
		}
	}
}
