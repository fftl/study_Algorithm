package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_05597_B5_과제안내신분 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		boolean[] yes = new boolean[31];
		
		for (int i = 0; i < 28; i++) {
			int k = sc.nextInt();
			yes[k] = true;
		}
		
		for (int i = 1; i < yes.length; i++) {
			if(!yes[i]) System.out.println(i);
		}
		
		sc.close();
	}
}