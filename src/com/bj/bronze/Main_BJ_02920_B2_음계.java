package com.bj.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_02920_B2_음계 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";
		
		if(str.equals(ascending)) {
			System.out.println("ascending");
		} else if(str.equals(descending)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}
