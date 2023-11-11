package com.baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_02752_B4_세수정렬 {

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[3];
		nums[0] = sc.nextInt();
		nums[1] = sc.nextInt();
		nums[2] = sc.nextInt();
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			if(i<nums.length-1) System.out.print(nums[i]+" ");
			else System.out.print(nums[i]);
		}
		
		sc.close();
	}
}
