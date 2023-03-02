package com.swexpertacademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_SW_D0_01288_새로운불면증치료법 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			boolean[] check = new boolean[10];
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;

			String str = null;
			while(chk(check)){
				cnt++;
				int num = n*cnt;
				str = Integer.toString(num);
				for (int i = 0; i < str.length(); i++) {
					int now = str.charAt(i)-'0';
					check[now] = true;
				}
			}

			System.out.println("#"+tc+" "+str);
		}
	}

	static boolean chk(boolean[] check){
		boolean c = true;
		for (int i = 0; i < 10; i++) {
			if (!check[i]) return true;
		}
		return false;
	}
}
