package com.zother.mock;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D0 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/sw_input_1873.txt")); // input 가져오기

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(br.readLine());
	}

}
