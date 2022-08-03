package com.bj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main_BJ_S2_6603_로또 {
	
	public static void permutations() {
		
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		while(cnt != 0) {
			int[] nums = new int[cnt];
			
			for(int i=0; i<cnt; i++) {
				nums[i] = sc.nextInt();
			}
			
			System.out.println(Arrays.toString(nums));
			
			cnt = sc.nextInt();
		}
		
		sc.close();
	}//main
}//class
