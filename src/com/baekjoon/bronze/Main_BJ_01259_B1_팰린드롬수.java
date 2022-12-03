package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_01259_B1_팰린드롬수 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			if(n == 0) break;
			
			char[] arr = Integer.toString(n).toCharArray();
			
			//짝수라면
			if(arr.length%2==0) {
				boolean check = true;
				for (int j = 0; j < arr.length/2; j++) {
					if(arr[j] != arr[arr.length-1-j]) {
						check = false;
						break;
					}
				}
				if(check) System.out.println("yes");
				else System.out.println("no");
			} else {
				boolean check = true;
				for (int j = 0; j < arr.length/2; j++) {
					if(arr[j] != arr[arr.length-1-j]) {
						check = false;
						break;
					}
				}
				if(check) System.out.println("yes");
				else System.out.println("no");
			}
		}
		sc.close();
	}
}
