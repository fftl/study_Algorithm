package com.baekjoon.gold;

import java.util.Scanner;

public class Main_BJ_01107_G5_리모컨 {
	static int len, t, cha, res;
	static boolean[] check;
	
	static void dfs(String num) {
		int nowNum = Integer.parseInt(num);
		if(nowNum>1000000) return;
		
		if(Math.abs(t-nowNum) < res) {
			cha = nowNum;
			res = Math.abs(t-nowNum);
		} else if (Math.abs(t-nowNum) == res){
			if(nowNum < cha) {
				cha = nowNum;
			}
		}
		
		for (int i = 0; i < check.length; i++) {
			if(!check[i]) {
				dfs(num+i);
			}
		}
	}

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		len = Integer.toString(t).length();
		
		if(t == 100) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		int n = sc.nextInt();
		check = new boolean[10];
		
		for (int i = 0; i < n; i++) {
			int now = sc.nextInt();
			check[now] = true;
		}
//		System.out.println(Arrays.toString(check));
		res = Integer.MAX_VALUE;
		
		if(!check[0]) {
			if(Math.abs(t-0) < res) {
				cha = 0;
				res = Math.abs(t-0);
			}
		}
		
		for (int i = 1; i < check.length; i++) {
			if(!check[i]) {
				dfs(Integer.toString(i));
			}
		}
		
//		System.out.println(res);
//		System.out.println(cha);
		int aRes = Integer.toString(cha).length()+res;
		int bRes = Math.abs(t-100);
		if(aRes>0) System.out.println(Math.min(aRes, bRes));
		else System.out.println(bRes);
		sc.close();
	}
}
