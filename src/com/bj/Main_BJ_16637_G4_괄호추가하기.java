package com.bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_BJ_16637_G4_괄호추가하기 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		System.out.println(Arrays.toString(arr));
		
	}
}
