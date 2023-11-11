package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_05543_B4_상근날드 {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int hamburger1 = sc.nextInt();
		int hamburger2 = sc.nextInt();
		int hamburger3 = sc.nextInt();
		int juice1 = sc.nextInt();
		int juice2 = sc.nextInt();
		
		int minHamburger = Math.min(hamburger3, Math.min(hamburger1, hamburger2));
		int minJuice= Math.min(juice1, juice2);
		
		System.out.println(minHamburger+minJuice-50);
		sc.close();
	}
}
