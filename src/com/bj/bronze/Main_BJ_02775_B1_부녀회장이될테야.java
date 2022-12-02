package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02775_B1_부녀회장이될테야 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[14+1][14+1];
		
		for (int i = 0; i < arr.length; i++) {
			arr[0][i] = i;
		}
		
		for (int i = 1; i < 14+1; i++) {
			for (int j = 1; j < 14+1; j++) {
				for (int k = 1; k <= j; k++) {
					arr[i][j] += arr[i-1][k];
				}
			}
		}
		
		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			System.out.println(arr[k][n]);
		}
	}
}
