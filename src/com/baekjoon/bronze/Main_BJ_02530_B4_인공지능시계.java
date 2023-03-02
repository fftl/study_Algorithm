package com.baekjoon.bronze;

import java.util.Scanner;

public class Main_BJ_02530_B4_인공지능시계 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int min = sc.nextInt();
		int sec = sc.nextInt();

		int time = sc.nextInt();

		sec += time;
		if(sec >= 60){
			min += sec/60;
			sec = sec%60;
		}
		if(min >= 60){
			hour += min/60;
			min = min%60;
		}
		if(hour >= 24){
			hour = hour%24;
		}

		System.out.println(hour+" "+min+" "+sec);
		sc.close();
	}
}
