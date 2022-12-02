package com.bj.bronze;

import java.util.Scanner;

public class Main_BJ_02292_B2_벌집 {

	//한 층 바깥으로 나갈 때마다 개수가 6씩 증가 1 6 12 18 ...
	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int run = 1;
		int gop = 6;
		int cnt = 1;
		
		if(n==1) {
			System.out.println(1);
			sc.close();
			return;
		}
		
		while(true) {
			run += gop;
			if(run >= n) {
				break;
			}
			gop+=6;
			cnt++;
		}
		
		System.out.println(cnt+1);
		sc.close();
	}
}
