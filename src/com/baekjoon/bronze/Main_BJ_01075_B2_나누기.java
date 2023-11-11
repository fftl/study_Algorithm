package com.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_01075_B2_나누기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		String basic = Integer.toString(N);

		String result = "";
		for (int i = 0; i <= 100; i++) {
			String num = Integer.toString(i);
			if(num.length()<2){
				num = "0"+num;
			}

			int now = Integer.parseInt(basic.substring(0, basic.length()-2)+num);
			if(now%F==0){
				result = num;
				break;
			}
		}

		System.out.println(result);
	}
}
